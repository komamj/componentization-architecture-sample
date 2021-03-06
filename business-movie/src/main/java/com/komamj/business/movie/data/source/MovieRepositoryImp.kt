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
import com.komamj.business.movie.data.source.local.LocalDataSource
import com.komamj.business.movie.data.source.remote.RemoteDataSource
import com.komamj.common.entities.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieRepositoryImp @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
) : MovieRepository {
    override suspend fun getPopularMovie(
        page: Int,
        forceUpdate: Boolean
    ): Resource<List<Movie>> {
        return if (forceUpdate) {
            val result = remoteDataSource.getPopularMovie(page)
            if (result is Resource.Success) {
                result.data?.run {
                    // localDataSource.saveMovie(this)
                }
            }
            result
        } else {
            localDataSource.getPopularMovie(page)
        }
    }

    override suspend fun getTopRatedMovie(page: Int, forceUpdate: Boolean): Resource<List<Movie>> {
        return if (forceUpdate) {
            val result = remoteDataSource.getTopRatedMovie(page)
            if (result is Resource.Success) {
                result.data?.run {
                    // localDataSource.saveMovie(this)
                }
            }
            result
        } else {
            localDataSource.getPopularMovie(page)
        }
    }

    override suspend fun getNowPlayingMovie(
        page: Int,
        forceUpdate: Boolean
    ): Resource<List<Movie>> {
        return if (forceUpdate) {
            val result = remoteDataSource.getNowPlayingMovie(page)
            if (result is Resource.Success) {
                result.data?.run {
                    // localDataSource.saveMovie(this)
                }
            }
            result
        } else {
            localDataSource.getPopularMovie(page)
        }
    }

    override suspend fun getUpcomingMovie(page: Int, forceUpdate: Boolean): Resource<List<Movie>> {
        return if (forceUpdate) {
            val result = remoteDataSource.getUpcomingMovie(page)
            if (result is Resource.Success) {
                result.data?.run {
                    // localDataSource.saveMovie(this)
                }
            }
            result
        } else {
            localDataSource.getPopularMovie(page)
        }
    }

    /**
     * Get a list of similar movies
     */
    override suspend fun getSimilarMovie(
        movieId: Int,
        forceUpdate: Boolean
    ): Resource<List<Movie>> {
        TODO("Not yet implemented")
    }

    /**
     * Get a list of recommended movies for a movie.
     */
    override suspend fun getRecommendedMovie(
        movieId: Int,
        forceUpdate: Boolean
    ): Resource<List<Movie>> {
        TODO("Not yet implemented")
    }

    override suspend fun getImages(movieId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun postRatingMovie(movieId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun searchMovie(
        keyword: String,
        includeAdult: Boolean
    ): Resource<List<Movie>> {
        TODO("Not yet implemented")
    }
}
