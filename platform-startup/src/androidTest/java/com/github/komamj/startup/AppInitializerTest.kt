package com.github.komamj.startup

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