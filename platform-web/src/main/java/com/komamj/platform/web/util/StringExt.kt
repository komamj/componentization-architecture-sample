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
package com.komamj.platform.web.util

import android.net.Uri
import androidx.annotation.RestrictTo

@RestrictTo(RestrictTo.Scope.LIBRARY)
fun String.clearQueryAndFragment(): String = let {
    val originUri = Uri.parse(this).buildUpon().build()
    val newUri = Uri.Builder()
        .scheme(originUri.scheme)
        .encodedAuthority(originUri.encodedAuthority)
        .encodedPath(originUri.encodedPath)
    newUri.build().toString()
}
