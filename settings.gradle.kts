pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    plugins {
        id("org.jetbrains.kotlin.jvm") version "1.9.10"
        id("org.jetbrains.kotlin.android") version "1.9.10"
        id("org.jetbrains.kotlin.kapt") version "1.9.10"
        id("com.android.application") version "8.1.1"
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MiBlisterApp"
include(":app")
