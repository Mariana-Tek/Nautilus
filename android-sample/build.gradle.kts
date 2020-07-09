import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(Versions.COMPILE_SDK)
    buildToolsVersion = Versions.BUILD_TOOLS_VERSION

    defaultConfig {
        applicationId = "io.marianatek.nautilus.grittycore"
        minSdkVersion(Versions.MIN_SDK)
        targetSdkVersion(Versions.TARGET_SDK)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
    buildTypes {
        getByName("release")  {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

}

dependencies {
    implementation(kotlin("stdlib-jdk7", KotlinCompilerVersion.VERSION))
    implementation(project(":MarianaKit"))

    implementation(Deps.APP_COMPAT)
    implementation(Deps.CORE_KTX)
    implementation(Deps.Coroutines.ANDROID)
    implementation(Deps.CONSTRAINT_LAYOUT)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.2.0")
    testImplementation(Deps.JUNIT)
    implementation("com.github.Mariana-Tek.DKouple:library:4.3.0")
    implementation("com.github.Mariana-Tek.DKouple:annotation:4.3.0")
    implementation("androidx.recyclerview:recyclerview:1.1.0")
}
