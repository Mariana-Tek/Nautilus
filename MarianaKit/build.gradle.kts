import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version Versions.KOTLIN
}

kotlin {
    sourceSets {
        all {
            languageSettings.apply {
                useExperimentalAnnotation("kotlinx.coroutines.ExperimentalCoroutinesApi")
                useExperimentalAnnotation("kotlinx.coroutines.InternalCoroutinesApi")
            }
        }
    }

    //
    // iOS Target Start
    //
    // select iOS target platform depending on the Xcode environment variables
    val iOSTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget =
        if (System.getenv("SDK_NAME")?.startsWith("iphoneos") == true)
            ::iosArm64
        else
            ::iosX64

    iOSTarget("ios") {
        binaries {
            framework {
                baseName = "MarianaKit"
            }
        }
    }

    targets.getByName<KotlinNativeTarget>("ios")
        .compilations["main"]
        .kotlinOptions
        .freeCompilerArgs += listOf("-Xobjc-generics", "-Xg0")
    // iOS Target End

    jvm("android")
    js {
        nodejs()
        compilations.all {
            this.compileKotlinTask.kotlinOptions {
                moduleKind = "umd"
                sourceMap = true
                sourceMapEmbedSources = null
            }
        }
    }

    sourceSets["commonMain"].dependencies {
        implementation(kotlin("stdlib-common", Versions.KOTLIN))
        implementation(Deps.Ktor.COMMON_CORE)
        implementation(Deps.Ktor.COMMON_JSON)
        implementation(Deps.Coroutines.COMMON)
        implementation(Deps.MP_SETTINGS)
        implementation(Deps.Ktor.COMMON_SERIALIZER)
        implementation(Deps.Serialization.COMMON)
        implementation(Deps.Stately.COMMON)
        implementation(Deps.Stately.CONCURRENCY)
    }

    sourceSets["androidMain"].dependencies {
        implementation(kotlin("stdlib", Versions.KOTLIN))
        implementation(Deps.Ktor.JVM_CORE)
        implementation(Deps.Ktor.JVM_JSON)
        implementation(Deps.Coroutines.JDK)
        implementation(Deps.Coroutines.ANDROID)
        implementation(Deps.Ktor.ANDROID_SERIALIZER)
        implementation(Deps.Ktor.ANDROID_CORE)
        implementation(Deps.Serialization.JVM)
    }

    sourceSets["iosMain"].dependencies {
        implementation(Deps.Ktor.IOS)
        implementation(Deps.Ktor.IOS_CORE)
        implementation(Deps.Ktor.IOS_JSON)
        implementation(Deps.Coroutines.NATIVE) {
            version {
                strictly("1.3.5-native-mt")
            }
        }
        implementation(Deps.Ktor.IOS_SERIALIZER)
        implementation(Deps.Serialization.NATIVE)
    }

    sourceSets["jsMain"].dependencies {
        implementation((kotlin("stdlib-js", Versions.KOTLIN)))
        implementation(Deps.Ktor.JS_CORE)
        implementation(Deps.Ktor.JS_JSON)
        implementation(Deps.Coroutines.JS)
        implementation(Deps.Ktor.JS_SERIALIZER)
        implementation(Deps.Serialization.JS)
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"

    val targetDir = File(buildDir, "xcode-frameworks")

    /// selecting the right configuration for the iOS
    /// framework depending on the environment
    /// variables set by Xcode build
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets
        .getByName<KotlinNativeTarget>("ios")
        .binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)

    from({ framework.outputDirectory })
    into(targetDir)

    /// generate a helpful ./gradlew wrapper with embedded Java path
    doLast {
        val gradlew = File(targetDir, "gradlew")
        gradlew.writeText("#!/bin/bash\n"
            + "export 'JAVA_HOME=${System.getProperty("java.home")}'\n"
            + "cd '${rootProject.rootDir}'\n"
            + "./gradlew \$@\n")
        gradlew.setExecutable(true)
    }
}

tasks.getByName("build").dependsOn(packForXcode)
