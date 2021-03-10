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
package com.komamj.business.splash

import android.Manifest
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
import com.alibaba.android.arouter.launcher.ARouter
import com.komamj.business.home.api.util.PATH_HOME_ACTIVITY
import com.komamj.business.splash.databinding.SplashActivitySplashBinding
import com.komamj.platform.permission.RequestPermissionActivity
import dagger.hilt.android.AndroidEntryPoint
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions
import timber.log.Timber

@AndroidEntryPoint
class SplashActivity : RequestPermissionActivity() {
    private lateinit var binding: SplashActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Timber.d("onCreate")

        binding = DataBindingUtil.setContentView(this, R.layout.splash_activity_splash)
        binding.lifecycleOwner = this

        initPermissions()
    }

    private fun initPermissions() {
        if (isPermissionGranted()) {
            launchMainPage()
        } else {
            requestPermission()
        }
    }

    @AfterPermissionGranted(PERMISSION_REQUEST_CODE)
    private fun launchMainPage() {
        if (isPermissionGranted()) {
            ARouter.getInstance().build(PATH_HOME_ACTIVITY)
                .withTransition(android.R.anim.fade_in, android.R.anim.fade_out)
                .navigation(this, object : NavCallback() {
                    override fun onArrival(postcard: Postcard?) {
                        finish()
                    }
                })
        } else {
            requestPermission()
        }
    }

    private fun requestPermission() {
        EasyPermissions.requestPermissions(
            this,
            getString(R.string.splash_app_name),
            PERMISSION_REQUEST_CODE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    private fun isPermissionGranted(): Boolean {
        return EasyPermissions.hasPermissions(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        )
    }

    companion object {
        private const val PERMISSION_REQUEST_CODE = 100
    }
}
