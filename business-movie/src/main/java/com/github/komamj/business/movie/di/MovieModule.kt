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
package com.github.komamj.business.movie.di

import com.github.komamj.business.movie.data.source.MovieRepository
import com.github.komamj.business.movie.data.source.MovieRepositoryImp
import com.github.komamj.business.movie.data.source.remote.WebService
import com.github.komamj.platform.network.di.CommonRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton
import retrofit2.Retrofit

@Module
@InstallIn(ApplicationComponent::class)
class MovieModule {
    @Singleton
    @Provides
    fun provideWebService(@CommonRetrofit retrofit: Retrofit): WebService {
        return retrofit.create(WebService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(movieRepository: MovieRepositoryImp): MovieRepository {
        return movieRepository
    }
}
