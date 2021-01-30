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
package com.github.komamj.platform.web.util

import android.webkit.WebView

private const val JAVASCRIPT = "javascript:"
private const val NATIVE_CALLBACK = "__NativeCallback"

fun WebView.evaluateJs(script: String, resultCallback: (String) -> Unit?) {
    post {
        evaluateJavascript("$JAVASCRIPT$script") {
            resultCallback(it)
        }
    }
}

/**
 * native 调用 js
 */
fun WebView.callJs(json: String?, resultCallback: (String) -> Unit?) {
    evaluateJs("$NATIVE_CALLBACK('$json')") {
        resultCallback(it)
    }
}
