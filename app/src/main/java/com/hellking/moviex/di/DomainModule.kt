package com.hellking.moviex.di

import com.hellking.moviex.networks.models.YtsMovieDetailDtoMapper
import com.hellking.moviex.networks.models.YtsMoviesListDtoMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {
    @Singleton
    @Provides
    fun provideYtsDtoMapper(): YtsMoviesListDtoMapper {
        return YtsMoviesListDtoMapper()
    }

    @Singleton
    @Provides
    fun provideYtsMovieDetailDtoMapper(): YtsMovieDetailDtoMapper {
        return YtsMovieDetailDtoMapper()
    }
}