package com.hellking.moviex.di

import com.hellking.moviex.networks.services.TmdbService
import com.hellking.moviex.networks.services.YtsService
import com.hellking.moviex.utils.BASE_URL
import com.hellking.moviex.utils.BASE_URL2
import com.hellking.moviex.utils.TMDB_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun providesYtsServices(): YtsService {
        return Retrofit.Builder()
            .baseUrl(BASE_URL2)
            .addConverterFactory(GsonConverterFactory.create())
            .client(
                OkHttpClient.Builder().build()
            )
            .build()
            .create(YtsService::class.java)
    }

    @Singleton
    @Provides
    fun providesTmdbServices(): TmdbService {
        return Retrofit.Builder()
            .baseUrl(TMDB_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(TmdbService::class.java)
    }
}