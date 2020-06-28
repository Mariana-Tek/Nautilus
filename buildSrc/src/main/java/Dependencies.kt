object Versions {
    const val MIN_SDK = 24
    const val TARGET_SDK = 29
    const val COMPILE_SDK = 29

    const val KOTLIN = "1.3.72"
    const val ANDROID_X = "1.1.0"
    const val ANDROID_GRADLE_PLUGIN = "4.0.0"
    const val BUILD_TOOLS_VERSION = "29.0.3"
    const val JUNIT = "4.12"
    const val SQL_DELIGHT = "1.3.0"
    const val KTOR = "1.3.2"
    const val MULTIPLATFORM_SETTINGS = "0.6"
    const val COROUTINES = "1.3.7"
    const val SERIALIZER = "0.20.0"
    const val SQL_JS = "1.0.0"
}

object Deps {
    const val APP_COMPAT =        "androidx.appcompat:appcompat:${Versions.ANDROID_X}"
    const val CORE_KTX =          "androidx.core:core-ktx:${Versions.ANDROID_X}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${Versions.ANDROID_X}"
    const val AGP =               "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_PLUGIN}"
    const val JUNIT =             "junit:junit:${Versions.JUNIT}"
    const val MP_SETTINGS =       "com.russhwolf:multiplatform-settings-no-arg:${Versions.MULTIPLATFORM_SETTINGS}"
    const val SQL_JS =            "sql.js"

    object Stately {
        const val COMMON =  "co.touchlab:stately-common:1.0.2"
        const val CONCURRENCY =  "co.touchlab:stately-concurrency:1.0.2"
    }

    object Serialization {
        const val COMMON = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.SERIALIZER}"
        const val JVM =    "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.SERIALIZER}"
        const val NATIVE = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:${Versions.SERIALIZER}"
        const val JS =     "org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:${Versions.SERIALIZER}"
    }

    object AndroidXTest {
        const val JUNIT =  "androidx.test.ext:junit:${Versions.ANDROID_X}"
        const val RUNNER = "androidx.test:runner:${Versions.ANDROID_X}"
        const val RULES =  "androidx.test:rules:${Versions.ANDROID_X}"
    }

    object KotlinTest {
        const val COMMON =      "org.jetbrains.kotlin:kotlin-test-common:${Versions.KOTLIN}"
        const val ANNOTATIONS = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.KOTLIN}"
        const val JVM =         "org.jetbrains.kotlin:kotlin-test:${Versions.KOTLIN}"
        const val JUNIT =       "org.jetbrains.kotlin:kotlin-test-junit:${Versions.KOTLIN}"
        const val REFLECT =     "org.jetbrains.kotlin:kotlin-reflect:${Versions.KOTLIN}"
    }
    object Coroutines {
        const val COMMON =  "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.COROUTINES}"
        const val JDK =     "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.COROUTINES}"
        const val NATIVE =  "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.COROUTINES}"
        const val ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
        const val JS =      "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${Versions.COROUTINES}"
        const val TEST =    "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.COROUTINES}"
    }
    object SqlDelight{
        const val GRADLE =         "com.squareup.sqldelight:gradle-plugin:${Versions.SQL_DELIGHT}"
        const val RUNTIME =        "com.squareup.sqldelight:runtime:${Versions.SQL_DELIGHT}"
        const val RUNTIME_JDK =    "com.squareup.sqldelight:runtime-jvm:${Versions.SQL_DELIGHT}"
//        const val DRIVER_JS =      "com.squareup.sqldelight:sqljs-driver:${Versions.SQL_DELIGHT}"
        const val RUNTIME_JS =     "com.squareup.sqldelight:runtime-js:${Versions.SQL_DELIGHT}"
        const val DRIVER_IOS =     "com.squareup.sqldelight:native-driver:${Versions.SQL_DELIGHT}"
        const val DRIVER_ANDROID = "com.squareup.sqldelight:android-driver:${Versions.SQL_DELIGHT}"
    }
    object Ktor {
        const val COMMON_CORE =       "io.ktor:ktor-client-core:${Versions.KTOR}"
        const val COMMON_JSON =       "io.ktor:ktor-client-json:${Versions.KTOR}"
        const val JVM_CORE =          "io.ktor:ktor-client-core-jvm:${Versions.KTOR}"
        const val ANDROID_CORE =      "io.ktor:ktor-client-okhttp:${Versions.KTOR}"
        const val JVM_JSON =          "io.ktor:ktor-client-json-jvm:${Versions.KTOR}"
        const val IOS =               "io.ktor:ktor-client-ios:${Versions.KTOR}"
        const val IOS_CORE =          "io.ktor:ktor-client-core-native:${Versions.KTOR}"
        const val IOS_JSON =          "io.ktor:ktor-client-json-native:${Versions.KTOR}"
        const val JS_CORE =           "io.ktor:ktor-client-js:${Versions.KTOR}"
        const val JS_JSON =           "io.ktor:ktor-client-json-js:${Versions.KTOR}"
        const val COMMON_SERIALIZER = "io.ktor:ktor-client-serialization:${Versions.KTOR}"
        const val ANDROID_SERIALIZER ="io.ktor:ktor-client-serialization-jvm:${Versions.KTOR}"
        const val IOS_SERIALIZER =    "io.ktor:ktor-client-serialization-native:${Versions.KTOR}"
        const val JS_SERIALIZER =     "io.ktor:ktor-client-serialization-js:${Versions.KTOR}"

    }
}
