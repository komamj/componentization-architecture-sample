import com.github.komamj.dependency.Dependencies
import com.github.komamj.util.addDaggerHilt
import com.github.komamj.util.addHiltAndroidX
import com.github.komamj.util.addLifecycle

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("com.github.komamj.common-configuration")
}

android {
    defaultConfig {
        versionCode = 1
        versionName = "1.0.0"

        resourcePrefix = "splash_"
    }

    buildFeatures.dataBinding = true
}

addDaggerHilt()
addHiltAndroidX()
addLifecycle()
dependencies {
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)

    implementation(project(":common"))
    implementation(project(":business-home-api"))

    testImplementation(Dependencies.JunitTest.JUNIT)
    testImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.JunitTest.MOCK_CORE)
    androidTestImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)
}