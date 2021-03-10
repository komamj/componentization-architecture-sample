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

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.komamj.business.movie.R
import com.komamj.business.movie.data.entities.Movie
import com.komamj.business.movie.databinding.MovieItemMovieHorizontalBinding

class MovieCategoryAdapter :
    ListAdapter<Movie, MovieCategoryAdapter.MovieCategoryVH>(MovieDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieCategoryVH {
        return MovieCategoryVH(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.movie_item_movie_horizontal,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MovieCategoryVH, position: Int) {
        bind(holder, position)
    }

    private fun bind(viewHolder: MovieCategoryVH, position: Int) {
        val movie = getItem(position)
        viewHolder.binding.movie = movie
        viewHolder.binding.clickListener = createOnClickListener(movie)
        viewHolder.binding.executePendingBindings()
    }

    private fun createOnClickListener(movie: Movie): View.OnClickListener {
        return View.OnClickListener {
            // todo launch detail page.
        }
    }

    class MovieCategoryVH(val binding: MovieItemMovieHorizontalBinding) :
        RecyclerView.ViewHolder(binding.root)

    private class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean {
            return oldItem == newItem
        }
    }
}
