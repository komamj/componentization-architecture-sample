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
package com.komamj.common.base

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.ThreadPolicy
import android.os.StrictMode.VmPolicy
import com.alibaba.android.arouter.launcher.ARouter
import com.komamj.common.BuildConfig
import com.komamj.platform.log.PlatformLog

open class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init() {
        initStrictMode()
        initLog()
        initRouter()
    }

    private fun initStrictMode() {
        if (BuildConfig.DEBUG) {
            enabledStrictMode()
        }
    }

    private fun initRouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openDebug()
            ARouter.printStackTrace()
        }
        ARouter.init(this)
    }

    private fun initLog() {
        PlatformLog.init(this)

        PlatformLog.d {
            ""
        }
    }

    private fun enabledStrictMode() {
        StrictMode.setThreadPolicy(
            ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectNetwork()
                .penaltyLog()
                .build()
        )
        StrictMode.setVmPolicy(
            VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .penaltyDeath()
                .build()
        )
    }
}
