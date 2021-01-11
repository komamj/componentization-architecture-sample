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
package com.github.komamj.business.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.launcher.ARouter
import com.github.komamj.business.home.api.util.PATH_HOME_ACTIVITY
import com.github.komamj.business.home.databinding.HomeActivityHomeBinding
import com.github.komamj.business.movie.api.util.PATH_MOVIE_MAIN_PAGE
import com.github.komamj.business.people.api.util.PATH_PEOPLE_MAIN_PAGE
import com.github.komamj.business.settings.api.util.PATH_SETTINGS_MAIN_PAGE
import com.github.komamj.business.tv.api.util.PATH_TV_MAIN_PAGE
import com.github.komamj.common.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@Route(path = PATH_HOME_ACTIVITY)
class HomeActivity : BaseActivity<HomeActivityHomeBinding>() {
    private var currentTag = TAG_MOVIE

    private val fragmentsHolder: Map<String, Fragment> by lazy {
        mapOf(
            TAG_MOVIE to ARouter.getInstance().build(PATH_MOVIE_MAIN_PAGE)
                .navigation(this) as Fragment,
            TAG_TV to ARouter.getInstance().build(PATH_TV_MAIN_PAGE)
                .navigation(this) as Fragment,
            TAG_PEOPLE to ARouter.getInstance().build(PATH_PEOPLE_MAIN_PAGE)
                .navigation(this) as Fragment,
            TAG_SETTINGS to ARouter.getInstance().build(PATH_SETTINGS_MAIN_PAGE)
                .navigation(this) as Fragment
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ARouter.getInstance().inject(this)

        binding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_movie -> {
                    showFragment(TAG_MOVIE)
                    true
                }
                R.id.nav_tv -> {
                    showFragment(TAG_TV)
                    true
                }
                R.id.nav_people -> {
                    showFragment(TAG_PEOPLE)
                    true
                }
                else -> false
            }
        }

        fragmentsHolder[TAG_MOVIE]?.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.container, this, TAG_MOVIE)
                .commit()
        }
    }

    private fun showFragment(readyFragmentTag: String) {
        if (currentTag == readyFragmentTag) {
            return
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentByTag(currentTag)
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment)
        }
        val readyFragment = supportFragmentManager.findFragmentByTag(readyFragmentTag)
        if (readyFragment != null) {
            fragmentTransaction.show(readyFragment)
        } else {
            fragmentsHolder[readyFragmentTag]?.run {
                fragmentTransaction.add(R.id.container, this, readyFragmentTag)
            }
        }
        fragmentTransaction.setCustomAnimations(
            android.R.anim.fade_in,
            android.R.anim.fade_out,
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        fragmentTransaction.commit()
        currentTag = readyFragmentTag
    }

    override fun getLayoutId() = R.layout.home_activity_home

    companion object {
        private const val TAG_MOVIE = "tag_movie"
        private const val TAG_TV = "tag_tv"
        private const val TAG_PEOPLE = "tag_people"
        private const val TAG_SETTINGS = "tag_settings"
    }
}
