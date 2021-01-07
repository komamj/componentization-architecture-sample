import com.github.komamj.dependency.Dependencies
import com.github.komamj.util.addLifecycle

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("com.github.komamj.common-configuration")
    id("com.alibaba.arouter")
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
    arguments {
        arg("AROUTER_MODULE_NAME", project.name)
        arg("AROUTER_GENERATE_DOC", "enable")
    }
}

android {
    defaultConfig {
        versionCode = 1
        versionName = "1.0"
    }
}

addLifecycle()
dependencies {
    implementation(Dependencies.Others.GSON)
    api(Dependencies.Others.ROUTER)
    kapt(Dependencies.Others.ROUTER_COMPILER)

    implementation(project(path = ":platform-log"))

    testImplementation(Dependencies.JunitTest.JUNIT)
    testImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.JunitTest.MOCK_CORE)
    androidTestImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)
}