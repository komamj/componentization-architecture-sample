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
package com.github.komamj.platform.web.optimize

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.MutableContextWrapper
import android.os.Bundle
import android.os.Looper
import android.webkit.WebSettings
import android.webkit.WebView
import androidx.annotation.RestrictTo
import java.util.Stack
import kotlin.text.Charsets.UTF_8
import timber.log.Timber

@RestrictTo(RestrictTo.Scope.LIBRARY)
object WebViewPool {
    private const val DEFAULT_POOL_SIZE = 3

    private lateinit var application: Application

    private val cachedWebView = Stack<WebView>()

    @get:JvmName("poolSize")
    val poolSize: Int = DEFAULT_POOL_SIZE

    var debuggable = false

    fun init(application: Application, debuggable: Boolean = false) {
        this.debuggable = debuggable

        application.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(p0: Activity, p1: Bundle?) {
                preload()
            }

            override fun onActivityStarted(p0: Activity) {
            }

            override fun onActivityResumed(p0: Activity) {
            }

            override fun onActivityPaused(p0: Activity) {
            }

            override fun onActivityStopped(p0: Activity) {
            }

            override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
            }

            override fun onActivityDestroyed(p0: Activity) {
                preload()
            }
        })
    }

    private fun preload() {
        Timber.d("preload")
        Looper.myQueue().addIdleHandler {
            if (cachedWebView.size < poolSize) {
                cachedWebView.push(createWebView(application))
            }
            false
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun createWebView(context: Context): WebView {
        val webView = WebView(MutableContextWrapper(context))
        with(webView) {
            with(settings) {
                allowFileAccessFromFileURLs = true
                allowContentAccess = true
                allowUniversalAccessFromFileURLs = true
                allowFileAccess = true
                loadsImagesAutomatically = false
                defaultTextEncodingName = UTF_8.toString()
                useWideViewPort = true // 将图片调整到适合webview的大小
                loadWithOverviewMode = true // 缩放至屏幕的大小
                setSupportZoom(false)
                displayZoomControls = false
                cacheMode = WebSettings.LOAD_DEFAULT
                domStorageEnabled = true
                databaseEnabled = true
                setAppCacheEnabled(true)
                javaScriptEnabled = true
                javaScriptCanOpenWindowsAutomatically = true
                mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW
                if (debuggable) {
                    WebView.setWebContentsDebuggingEnabled(true)
                }
            }
        }

        return webView
    }

    fun getWebView(context: Context): WebView {
        val webView = if (cachedWebView.isEmpty()) {
            createWebView(context)
        } else {
            cachedWebView.pop()
        }
        return webView.apply {
            val contextWrapper = this.context as MutableContextWrapper
            contextWrapper.baseContext = context
        }
    }
}
