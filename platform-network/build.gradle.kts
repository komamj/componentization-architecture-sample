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
        versionName = "1.0"
    }
}

dependencies {
    implementation(Dependencies.Others.HILT_ANDROID)
    kapt(Dependencies.Others.HILT_COMPILER)
    api(Dependencies.Others.RETROFIT)
    implementation(Dependencies.Others.GSON)
    implementation(Dependencies.Others.CONVERTER_GSON)
    implementation(Dependencies.Others.OKHTTP_LOGGING_INTERCEPTOR)

    testImplementation(Dependencies.JunitTest.JUNIT)
    testImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.JunitTest.MOCK_CORE)
    androidTestImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)
}