package com.hellking.moviex.networks.services

import com.hellking.moviex.networks.responses.MovieDetailResponse
import com.hellking.moviex.networks.responses.MoviesListResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface YtsService {

    /* Old
    @GET("movies_list")
    suspend fun movieList(
        @Query("p") page: Int = 1
    ): List<MoviesListResponse>

    @GET("movie_detail")
    suspend fun movieDetail(
        @Query("id") id: Int,
        @Query("with_images") with_images: Boolean = true,
        @Query("with_cast") with_cast: Boolean = true
    ): MovieDetailResponse
    */

    @GET("latest_movies")
    suspend fun latestMovies(): List<MoviesListResponse>

    @GET("popular_movies")
    suspend fun popularMovies(): List<MoviesListResponse>

    @GET("most_liked")
    suspend fun mostLikedMovies(): List<MoviesListResponse>

    @GET("movie_detailv2")
    suspend fun movieDetailv2(
        @Query("name") name: String,
        @Query("url") url: String
    ): MovieDetailResponse
}