import com.github.komamj.util.addDaggerHilt
import com.github.komamj.util.addHiltAndroidX
import com.github.komamj.util.addLifecycle

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.github.komamj.common-configuration")
}

android {
    defaultConfig {
        applicationId = "com.github.komamj.host"
        versionCode = 1
        versionName = "1.0.0"
    }

    buildFeatures.dataBinding = true

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false
        }

        getByName("release") {
            isMinifyEnabled = true
            isShrinkResources = true
            isZipAlignEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

tasks.register("installHooks") {
    project.exec {
        commandLine("./../scripts/install-hooks.sh")
    }
}

addDaggerHilt()
addHiltAndroidX()
addLifecycle()
dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    implementation(project(":business-splash"))
    implementation(project(":business-home"))
    implementation(project(":business-people"))
    implementation(project(":business-tv"))
    implementation(project(":business-mine"))
    implementation(project(":business-settings"))
    implementation(project(":common"))
}