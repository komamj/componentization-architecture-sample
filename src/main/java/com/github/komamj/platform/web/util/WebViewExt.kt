package com.github.komamj.platform.web.util

import android.webkit.WebView

private const val JAVASCRIPT = "javascript:"

fun WebView.evaluateJs(script: String, resultCallback: (String) -> Unit?) {
    post {
        evaluateJavascript("$JAVASCRIPT$script") {
            resultCallback(it)
        }
    }
}