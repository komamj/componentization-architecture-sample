import com.github.komamj.dependency.Dependencies
import com.github.komamj.util.addLifecycle

plugins {
    id("com.android.library")
    kotlin("android")
    id("com.github.komamj.common-configuration")
}

android {
    defaultConfig {
        versionCode = 1
        versionName = "1.0"
    }
}

addLifecycle()
dependencies {
    api(Dependencies.Others.PERMISSION)
    implementation(project(":platform-log"))

    testImplementation(Dependencies.JunitTest.JUNIT)
    testImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.JunitTest.MOCK_CORE)
    androidTestImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)
}