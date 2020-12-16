plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("maven-publish")
}

android {
    compileSdkVersion(30)
    buildToolsVersion("30.0.2")

    defaultConfig {
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }

    buildFeatures {
        dataBinding = true
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false

            isTestCoverageEnabled = true
        }

        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "consumer-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(Dependencies.Kotlin.STDLIB)
    api(Dependencies.Others.GLIDE)
    kapt(Dependencies.Others.GLIDE_COMPILER)
    implementation(Dependencies.Others.GLIDE_OKHTTP_INTEGRATION) {
        isTransitive = false
    }
    implementation(Dependencies.Others.OKHTTP)

    testImplementation(Dependencies.JunitTest.JUNIT)
    testImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.JUNIT)
    androidTestImplementation(Dependencies.JunitTest.MOCK_CORE)
    androidTestImplementation(Dependencies.JunitTest.TRUTH)
    androidTestImplementation(Dependencies.AndroidTest.ESPRESSO_CORE)
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components.findByName("release"))
                groupId = "com.github.komamj"
                artifactId = "platform-image"
                version = "0.0.1"
            }
        }
    }
}