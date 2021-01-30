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
package com.github.komamj.platform.web.api

import android.content.Context
import android.content.Intent
import androidx.annotation.RestrictTo
import com.alibaba.android.arouter.facade.annotation.Route
import com.github.komamj.platform.web.WebActivity
import com.github.komamj.platform.web.util.PATH_WEB_CONTAINER_SERVICE

@RestrictTo(RestrictTo.Scope.LIBRARY)
@Route(path = PATH_WEB_CONTAINER_SERVICE)
class WebContainerService : WebContainer {
    private lateinit var applicationContext: Context

    override fun init(context: Context) {
        this.applicationContext = context
    }

    override fun launchWebPage(context: Context, url: String) {
        context.startActivity(Intent(context, WebActivity::class.java))
    }
}
