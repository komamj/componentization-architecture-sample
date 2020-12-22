package com.github.komamj.util

import com.github.komamj.dependency.Dependencies
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

private const val IMPLEMENTATION = "implementation"
private const val KAPT = "kapt"

fun Project.addLifecycle(configurationName: String = IMPLEMENTATION) {
    dependencies {
        add(
            configurationName,
            Dependencies.AndroidX.LIFECYCLE
        )
        add(
            configurationName,
            Dependencies.AndroidX.LIFECYCLE_COMMON_JAVA8
        )
        add(
            configurationName,
            Dependencies.AndroidX.LIFECYCLE_VIEWMODEL
        )
        add(
            configurationName,
            Dependencies.AndroidX.LIFECYCLE_LIVE_DATA
        )
        add(
            configurationName,
            Dependencies.AndroidX.LIFECYCLE_SERVICE
        )
        add(
            configurationName,
            Dependencies.AndroidX.LIFECYCLE_PROCESS
        )
        add(
            configurationName,
            Dependencies.AndroidX.APPCOMPAT
        )
    }
}

fun Project.addConstraintLayout(configurationName: String = IMPLEMENTATION) {
    dependencies {
        add(
            configurationName,
            Dependencies.AndroidX.CONSTRAINT_LAYOUT
        )
    }
}

fun Project.addDaggerHilt(configurationName: String = IMPLEMENTATION) {
    dependencies {
        add(configurationName, Dependencies.Others.HILT_ANDROID)
        add(KAPT, Dependencies.Others.HILT_COMPILER)
    }
}

fun Project.addCoroutines(configurationName: String = IMPLEMENTATION) {
    dependencies {
        add(
            configurationName,
            Dependencies.Kotlin.COROUTINES_CORE
        )
        add(
            configurationName,
            Dependencies.Kotlin.COROUTINES_ANDROID
        )
    }
}