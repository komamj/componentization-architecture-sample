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
package com.komamj.business.movie.presentation

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.alibaba.android.arouter.facade.annotation.Route
import com.komamj.business.movie.R
import com.komamj.business.movie.api.util.PATH_MOVIE_MAIN_PAGE
import com.komamj.business.movie.databinding.MovieFragmentMovieWrapperBinding
import com.komamj.common.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
@Route(path = PATH_MOVIE_MAIN_PAGE)
class MovieWrapperFragment : BaseFragment<MovieFragmentMovieWrapperBinding>() {
    private lateinit var adapter: MovieWrapperAdapter

    private lateinit var viewModel: MovieWrapperViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("onViewCreated")

        with(binding.recyclerView) {
            layoutManager = LinearLayoutManager(context).apply {
                orientation = LinearLayoutManager.VERTICAL
            }
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            this@MovieWrapperFragment.adapter = MovieWrapperAdapter()
            adapter = this@MovieWrapperFragment.adapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(MovieWrapperViewModel::class.java)
        binding.viewModel = viewModel

        observeData()

        viewModel.start()
    }

    private fun observeData() {
        viewModel.homeModelList.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun getLayoutId() = R.layout.movie_fragment_movie_wrapper

    companion object {
        fun newInstance(): MovieWrapperFragment {
            return MovieWrapperFragment()
        }
    }
}
