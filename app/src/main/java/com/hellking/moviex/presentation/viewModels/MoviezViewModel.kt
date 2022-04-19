package com.hellking.moviex.presentation.viewModels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hellking.moviex.domain.models.MovieDetailUser
import com.hellking.moviex.domain.models.MovieListUser
import com.hellking.moviex.repository.YtsRepo
import com.hellking.moviex.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MoviezViewModel @Inject constructor(
    private val ytsRepo: YtsRepo
) : ViewModel() {
    // old states
    // val movieListState: MutableState<Resource<List<MovieListUser>>> = mutableStateOf(Resource.Empty())

    val movieDetailState: MutableState<Resource<MovieDetailUser>> = mutableStateOf(Resource.Empty())
    val latestMoviesState: MutableState<Resource<List<MovieListUser>>> = mutableStateOf(Resource.Empty())
    val popularMoviesState: MutableState<Resource<List<MovieListUser>>> = mutableStateOf(Resource.Empty())
    val likedMoviesState: MutableState<Resource<List<MovieListUser>>> = mutableStateOf(Resource.Empty())

    /* old functions
    fun getMovies(page: Int = 1) {
        movieListState.value = Resource.Loading()
        viewModelScope.launch {
            movieListState.value = ytsRepo.getMovieList(page)
        }
    }


    fun getMovieDetail(id: Int) {
        movieDetailState.value = Resource.Loading()
        viewModelScope.launch {
            movieDetailState.value = ytsRepo.getMovieDetail(id)
        }
    }
    */

    fun getLatestMovies() {
        latestMoviesState.value = Resource.Loading()
        viewModelScope.launch {
            latestMoviesState.value = ytsRepo.latestMovies()
        }
    }

    fun getPopularMovies() {
        popularMoviesState.value = Resource.Loading()
        viewModelScope.launch {
            popularMoviesState.value = ytsRepo.popularMovies()
        }
    }

    fun getMostLikedMovies() {
        likedMoviesState.value = Resource.Loading()
        viewModelScope.launch {
            likedMoviesState.value = ytsRepo.mostLikedMovies()
        }
    }

    fun getMovieDetailv2(name: String, url: String) {
        movieDetailState.value = Resource.Loading()
        viewModelScope.launch {
            movieDetailState.value = ytsRepo.getMovieDetailv2(name, url)
        }
    }
}