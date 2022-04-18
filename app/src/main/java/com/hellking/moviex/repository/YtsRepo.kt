package com.hellking.moviex.repository

import com.hellking.moviex.domain.models.MovieDetailUser
import com.hellking.moviex.domain.models.MovieListUser
import com.hellking.moviex.networks.models.YtsMoviesListDtoMapper
import com.hellking.moviex.networks.models.YtsMovieDetailDtoMapper
import com.hellking.moviex.networks.services.YtsService
import com.hellking.moviex.utils.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class YtsRepo @Inject constructor(
    private val ytsService: YtsService,
    private val ytsMoviesListDtoMapper: YtsMoviesListDtoMapper,
    private val ytsMovieDetailDtoMapper: YtsMovieDetailDtoMapper
): YtsRepoInterface {
    /* Old functions
    override suspend fun getMovieList(page: Int): Resource<List<MovieListUser>> {
        return try {
            val response = ytsService.movieList(page = page)
            Resource.Success(ytsMoviesListDtoMapper.mapToDomain(response))
        } catch (e: Exception) {
            Resource.Error("YtsRepo -> getMovieList: $e")
        }
    }

        override suspend fun getMovieDetail(id: Int): Resource<MovieDetailUser> {
        return try {
            val response = ytsService.movieDetail(id = id)
            Resource.Success(ytsMovieDetailDtoMapper.mapToDomain(response))
        } catch (e: Exception) {
            Resource.Error("YtsRepo -> getMovieDetail: $e")
        }
    }
    */

    override suspend fun latestMovies(): Resource<List<MovieListUser>> {
        return try {
            val response = ytsService.latestMovies()
            Resource.Success(ytsMoviesListDtoMapper.mapToDomain(response))
        } catch (e: Exception) {
            Resource.Error("YtsRepo -> latestMovies: $e")
        }
    }

    override suspend fun popularMovies(): Resource<List<MovieListUser>> {
        return try {
            val response = ytsService.popularMovies()
            Resource.Success(ytsMoviesListDtoMapper.mapToDomain(response))
        } catch (e: Exception) {
            Resource.Error("YtsRepo -> popularMovies: $e")
        }
    }

    override suspend fun mostLikedMovies(): Resource<List<MovieListUser>> {
        return try {
            val response = ytsService.mostLikedMovies()
            Resource.Success(ytsMoviesListDtoMapper.mapToDomain(response))
        } catch (e: Exception) {
            Resource.Error("YtsRepo -> mostLikedMovies: $e")
        }
    }

    override suspend fun getMovieDetailv2(name: String, url: String): Resource<MovieDetailUser> {
        return try {
            val response = ytsService.movieDetailv2(name, url)
            Resource.Success(ytsMovieDetailDtoMapper.mapToDomain(response))
        } catch (e: Exception) {
            Resource.Error("YtsRepo -> getMovieDetailv2: $e")
        }
    }

}