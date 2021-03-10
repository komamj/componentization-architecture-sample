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
