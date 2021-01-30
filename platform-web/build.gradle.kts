import com.github.komamj.util.addLifecycle
import com.github.komamj.dependency.Dependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.github.komamj.common-configuration")
    id("kotlin-android")
}

android {
    defaultConfig {
        versionCode = 1
        versionName = "1.0.0"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    buildFeatures {
        dataBinding = true
    }
}

addLifecycle()

dependencies {
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.FRAGMENT)
    implementation(Dependencies.AndroidX.WEBKIT)

    implementation(project(":platform-log"))
    implementation(project(":platform-router"))

    testImplementation(Dependencies.JunitTest.JUNIT)
    testImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.JunitTest.MOCK_CORE)
    androidTestImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)
}
