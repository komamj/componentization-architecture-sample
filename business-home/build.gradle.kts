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
    id("com.alibaba.arouter")
}

android {
    defaultConfig {
        versionCode = 1
        versionName = "1.0.0"

        resourcePrefix = "home_"
    }

    buildFeatures.dataBinding = true
}

addDaggerHilt()
addHiltAndroidX()
addLifecycle()
dependencies {
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependencies.AndroidX.FRAGMENT)

    implementation(project(":common"))
    api(project(":business-home-api"))
    implementation(project(":business-movie-api"))
    implementation(project(":business-tv-api"))
    implementation(project(":business-people-api"))
    implementation(project(":business-mine-api"))

    testImplementation(Dependencies.JunitTest.JUNIT)
    testImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.JunitTest.MOCK_CORE)
    androidTestImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)
}