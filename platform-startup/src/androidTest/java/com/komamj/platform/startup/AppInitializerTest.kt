/*
 * Copyright 2021 komamj
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
package com.komamj.platform.startup

import android.content.Context
import androidx.startup.AppInitializer
import androidx.startup.StartupException
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import com.google.common.truth.Truth
import org.junit.Assert.fail
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@MediumTest
class AppInitializerTest {
    private lateinit var context: Context
    private lateinit var appInitializer: AppInitializer

    @Before
    fun setUp() {
        context = ApplicationProvider.getApplicationContext()

        appInitializer = AppInitializer.getInstance(context)
    }

    @Test
    fun basicInitializationTest() {
        val initializerNoDependencies =
            appInitializer.initializeComponent(InitializerNoDependencies::class.java)

        Truth.assertThat(initializerNoDependencies).isNotNull()
    }

    @Test
    fun initializationWithDependencies() {
        val initializerWithDependency =
            appInitializer.initializeComponent(InitializerWithDependency::class.java)

        Truth.assertThat(initializerWithDependency).isNotNull()
    }

    @Test
    fun discoveredWithDependency() {
        val isEagerlyInitialized =
            appInitializer.isEagerlyInitialized(DiscoveredWithDependencyInitializer::class.java)

        Truth.assertThat(isEagerlyInitialized).isTrue()
    }

    @Test
    fun initializationWithCyclicDependencies() {
        try {
            appInitializer.initializeComponent(CyclicDependencyInitializer::class.java)
            fail()
        } catch (exception: StartupException) {
            Truth.assertThat(exception.localizedMessage).contains("Cycle detected.")
        }
    }
}
