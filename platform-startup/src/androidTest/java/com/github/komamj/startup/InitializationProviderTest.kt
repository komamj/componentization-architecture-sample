package com.github.komamj.startup

import android.content.ContentValues
import android.net.Uri
import androidx.startup.InitializationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
@MediumTest
class InitializationProviderTest {
    private lateinit var provider: InitializationProvider

    @Before
    fun setUp() {
        provider = InitializationProvider()
    }

    @Test(expected = IllegalStateException::class)
    fun should_throws_exception_when_insert() {
        val uri = Mockito.mock(Uri::class.java)
        val values = ContentValues()

        provider.insert(uri, values)
    }

    @Test(expected = IllegalStateException::class)
    fun should_throws_exception_when_update() {
        val uri = Mockito.mock(Uri::class.java)
        val values = ContentValues()

        provider.update(uri, values, null, null)
    }

    @Test(expected = IllegalStateException::class)
    fun should_throws_exception_when_delete() {
        val uri = Mockito.mock(Uri::class.java)

        provider.delete(uri, null, null)
    }

    @Test(expected = IllegalStateException::class)
    fun should_throws_exception_when_getType() {
        val uri = Mockito.mock(Uri::class.java)

        provider.getType(uri)
    }
}