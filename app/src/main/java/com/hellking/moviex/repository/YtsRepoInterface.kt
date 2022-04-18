package com.hellking.moviex.repository

import com.hellking.moviex.domain.models.MovieDetailUser
import com.hellking.moviex.domain.models.MovieListUser
import com.hellking.moviex.utils.Resource

interface YtsRepoInterface {
    // suspend fun getMovieList(page: Int = 1): Resource<List<MovieListUser>>

    // suspend fun getMovieDetail(id: Int): Resource<MovieDetailUser>

    suspend fun latestMovies(): Resource<List<MovieListUser>>

    suspend fun popularMovies(): Resource<List<MovieListUser>>

    suspend fun mostLikedMovies(): Resource<List<MovieListUser>>

    suspend fun getMovieDetailv2(name: String, url: String): Resource<MovieDetailUser>
}