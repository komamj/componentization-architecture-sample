package com.github.komamj.platform.web.api

import android.webkit.JavascriptInterface
import timber.log.Timber

class AndroidJs {
    @JavascriptInterface
    fun __CallNative(input: String?) {
        Timber.d("__CallNative $input")
    }
}