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
package com.komamj.business.movie.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.komamj.business.movie.data.entities.Movie
import com.komamj.business.movie.data.entities.MovieWrapper
import com.komamj.business.movie.presentation.MovieCategoryAdapter
import com.komamj.business.movie.presentation.MovieWrapperAdapter

@BindingAdapter("movieWrapperList")
fun bindMovieWrapperList(recyclerView: RecyclerView, movieList: List<MovieWrapper>) {
    if (recyclerView.adapter == null) {
        with(recyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(recyclerView.context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            itemAnimator = DefaultItemAnimator()
            adapter = MovieWrapperAdapter()
        }
    }
    if (recyclerView.adapter is MovieWrapperAdapter) {
        (recyclerView.adapter as MovieWrapperAdapter).submitList(movieList)
    }
}

@BindingAdapter("movieList")
fun bindMovieList(recyclerView: RecyclerView, movieList: List<Movie>) {
    if (recyclerView.adapter == null) {
        with(recyclerView) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(recyclerView.context).apply {
                orientation = LinearLayoutManager.HORIZONTAL
            }
            itemAnimator = DefaultItemAnimator()
            adapter = MovieCategoryAdapter()
        }
    }
    if (recyclerView.adapter is MovieCategoryAdapter) {
        (recyclerView.adapter as MovieCategoryAdapter).submitList(movieList)
    }
}
