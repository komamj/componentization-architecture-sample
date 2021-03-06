import com.github.komamj.util.addLifecycle
import com.github.komamj.dependency.Dependencies

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.github.komamj.common-configuration")
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

addLifecycle(configurationName = "api")
dependencies {
    api(project(":platform-image"))
    api(project(":platform-log"))
    api(project(":platform-router"))
    api(project(":platform-network"))
    api(project(":platform-database"))
    api(project(":platform-permission"))
    api(project(":platform-storage"))
    api(project(":platform-statistics"))
    api(project(":platform-startup"))
    api(project(":platform-ui"))
    api(project(":platform-domain"))

    testImplementation(Dependencies.JunitTest.JUNIT)
    testImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.JunitTest.MOCK_CORE)
    androidTestImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)
}
