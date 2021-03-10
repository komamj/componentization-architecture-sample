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
package com.github.komamj.platform.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.core.preferencesKey
import java.io.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map

/**
 * dataStore.data throws an IOException when an error is encountered when reading data
 */
private fun Flow<Preferences>.catchIOException() = this.catch { exception ->
    if (exception is IOException) {
        emit(emptyPreferences())
    } else {
        throw exception
    }
}

fun DataStore<Preferences>.readInt(key: String, defaultValue: Int = -1): Flow<Int> {
    val preferencesKey = preferencesKey<Int>(key)
    return data.catchIOException().map {
        it[preferencesKey] ?: defaultValue
    }
}

suspend fun DataStore<Preferences>.writeInt(key: String, value: Int) {
    val preferencesKey = preferencesKey<Int>(key)
    edit {
        it[preferencesKey] = value
    }
}

fun DataStore<Preferences>.readBoolean(key: String, defaultValue: Boolean = false): Flow<Boolean> {
    val preferencesKey = preferencesKey<Boolean>(key)
    return data.catchIOException().map {
        it[preferencesKey] ?: defaultValue
    }
}

suspend fun DataStore<Preferences>.writeBoolean(key: String, value: Boolean) {
    val preferencesKey = preferencesKey<Boolean>(key)
    edit {
        it[preferencesKey] = value
    }
}

fun DataStore<Preferences>.readString(key: String, defaultValue: String = ""): Flow<String> {
    val preferencesKey = preferencesKey<String>(key)
    return data.catchIOException().map {
        it[preferencesKey] ?: defaultValue
    }
}

suspend fun DataStore<Preferences>.writeString(key: String, value: String) {
    val preferencesKey = preferencesKey<String>(key)
    edit {
        it[preferencesKey] = value
    }
}
