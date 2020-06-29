include(":android-sample", ":MarianaKit", ":web-sample")
enableFeaturePreview("GRADLE_METADATA")
pluginManagement {
    repositories {
        maven { setUrl("https://dl.bintray.com/kotlin/kotlin-eap") }

        mavenCentral()

        maven { setUrl("https://plugins.gradle.org/m2/") }
    }
}
rootProject.name = "Nautilus"
