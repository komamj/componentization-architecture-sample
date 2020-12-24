/*
 * Copyright 2020 komamj
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.komamj.plugin

import com.android.build.gradle.*
import com.diffplug.gradle.spotless.SpotlessExtension
import com.github.komamj.Configuration
import com.github.komamj.dependency.Dependencies
import com.github.komamj.dependency.Versions
import com.github.komamj.util.LICENCE_HEADER
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class CommonConfiguration : Plugin<Project> {
    override fun apply(project: Project) {
        project.logger.info("CommonConfiguration plugin apply.")

        project.plugins.apply(KOTLIN_ANDROID_PLUGIN)
        project.plugins.apply(SPOTLESS_PLUGIN)
        project.plugins.apply("maven-publish")

        project.extensions.create(CUSTOM_CONFIGURATION, Configuration::class.java)

        // Configure common android build parameters.
        configureAndroidExtension(project)

        configureSpotless(project)

        configureDependencies(project)

        configureMavenPublish(project)
    }

    private fun configureAndroidExtension(project: Project) {
        val androidExtension = project.extensions.getByName(ANDROID_EXTENSION)
        if (androidExtension is BaseExtension) {
            androidExtension.apply {
                compileSdkVersion(Versions.Android.COMPILE_SDK_VERSION)
                buildToolsVersion(Versions.Android.BUILD_TOOLS_VERSION)

                defaultConfig {
                    minSdkVersion(Versions.Android.MIN_SDK_VERSION)
                    targetSdkVersion(Versions.Android.TARGET_SDK_VERSION)
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_1_8
                    targetCompatibility = JavaVersion.VERSION_1_8
                }

                project.tasks.withType(KotlinCompile::class.java).configureEach {
                    kotlinOptions {
                        jvmTarget = Versions.Android.JVM_TARGET
                    }
                }

                // Configure common proguard file settings.
                configureProguardSettings()
            }
        }
    }

    private fun BaseExtension.configureProguardSettings() {
        when (this) {
            is LibraryExtension -> defaultConfig {
                consumerProguardFiles(LIBRARY_PROGUARD_FILES)
            }
            is AppExtension -> buildTypes {
                getByName(BUILD_TYPE_RELEASE) {
                    isMinifyEnabled = true
                    isShrinkResources = true
                    isZipAlignEnabled = true
                    proguardFiles(
                        getDefaultProguardFile(DEFAULT_APPLICATION_PROGUARD_FILES),
                        APPLICATION_PROGUARD_FILES
                    )
                }
            }
        }
    }

    private fun configureSpotless(project: Project) {
        val spotlessExtension = project.extensions.getByName(SPOTLESS_EXTENSION)
        if (spotlessExtension is SpotlessExtension) {
            spotlessExtension.apply {
                kotlin {
                    target("**/*.kt")
                    ktlint().userData(
                        mapOf("max_line_length" to "120")
                    )
                    licenseHeader(LICENCE_HEADER)
                }
            }
        }
    }

    private fun configureDependencies(project: Project) {
        project.dependencies {
            add(
                "implementation",
                Dependencies.Kotlin.STDLIB
            )
        }

        addTestDependencies(project)
    }

    private fun addTestDependencies(project: Project) {
        project.dependencies {
            add(
                "testImplementation",
                Dependencies.JunitTest.JUNIT
            )
        }
    }

    private fun configureMavenPublish(project: Project) {
        project.afterEvaluate {
            val publishingExtension = project.extensions.getByName("publishing")
            if (publishingExtension is PublishingExtension) {
                publishingExtension.apply {
                    publications {
                        create("release", MavenPublication::class.java) {
                            from(components.findByName("release"))
                            groupId = "com.github.komamj"
                            artifactId = "startup"
                            version = "0.0.1"
                        }
                    }
                }
            }
        }


        project.plugins.all {
            when (this) {
                is LibraryPlugin -> {
                    project.extensions.getByType(LibraryExtension::class.java).run {

                    }
                }
            }
        }
    }

    companion object {
        private const val KOTLIN_ANDROID_PLUGIN = "kotlin-android"
        private const val SPOTLESS_PLUGIN = "com.diffplug.gradle.spotless"
        private const val SPOTLESS_EXTENSION = "spotless"
        private const val ANDROID_EXTENSION = "android"
        private const val CUSTOM_CONFIGURATION = "customConfiguration"
        private const val BUILD_TYPE_RELEASE = "release"
        private const val LIBRARY_PROGUARD_FILES = "consumer-rules.pro"
        private const val APPLICATION_PROGUARD_FILES = "proguard-rules.pro"
        private const val DEFAULT_APPLICATION_PROGUARD_FILES = "proguard-android-optimize.txt"
    }
}
