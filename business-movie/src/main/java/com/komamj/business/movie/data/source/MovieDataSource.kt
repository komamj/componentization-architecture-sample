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
package com.komamj.business.movie.data.source

import com.komamj.business.movie.data.entities.Movie
import com.komamj.common.entities.Resource

interface MovieDataSource {
    suspend fun getPopularMovie(page: Int): Resource<List<Movie>>

    suspend fun getTopRatedMovie(page: Int): Resource<List<Movie>>

    suspend fun getNowPlayingMovie(page: Int): Resource<List<Movie>>

    suspend fun getUpcomingMovie(page: Int): Resource<List<Movie>>

    /**
     * Get a list of similar movies
     */
    suspend fun getSimilarMovie(movieId: Int): Resource<List<Movie>>

    /**
     * Get a list of recommended movies for a movie.
     */
    suspend fun getRecommendedMovie(movieId: Int): Resource<List<Movie>>
}
