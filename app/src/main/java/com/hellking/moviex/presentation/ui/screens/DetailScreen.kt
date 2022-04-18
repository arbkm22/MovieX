package com.hellking.moviex.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.hellking.moviex.domain.models.MovieDetailUser
import com.hellking.moviex.presentation.viewModels.MoviezViewModel
import com.hellking.moviex.utils.Resource

@Composable
fun DetailScreen(
    navController: NavController,
    moviezViewModel: MoviezViewModel,
    //movieId: Int
    name: String,
    url: String
) {
    Log.d("name", "$name")
    val movieIdVar = remember {
        mutableStateOf<Resource<MovieDetailUser>>(Resource.Empty())
    }
    val movieNameVar = remember {
        mutableStateOf<Resource<MovieDetailUser>>(Resource.Empty())
    }
    val urlVar = remember {
        mutableStateOf<Resource<MovieDetailUser>>(Resource.Empty())
    }
    when (movieNameVar.value) {
        is Resource.Empty -> {
            // moviezViewModel.getMovieDetail(movieId)
            moviezViewModel.getMovieDetailv2(name, url)
            //movieIdVar.value = moviezViewModel.movieDetailState.value
            movieNameVar.value = moviezViewModel.movieDetailState.value
            urlVar.value = moviezViewModel.movieDetailState.value
        }
        is Resource.Error -> {
            Log.d("DetailScr->movieDetail", "DetailScreen me lafda he ${movieNameVar.value.message}")
            Text(text = "DetailScreen me error he")
        }
        is Resource.Loading -> {
            CircularProgressIndicator()
            movieNameVar.value = moviezViewModel.movieDetailState.value
            urlVar.value = moviezViewModel.movieDetailState.value
        }
        is Resource.Success -> {
            val tempContent = movieNameVar.value.data
            DetailScreenSuccess(
                navController = navController,
                moviezViewModel = moviezViewModel,
                movieDetail = tempContent!!
            )
        }
    }
}

@Composable
fun DetailScreenSuccess(
    navController: NavController,
    moviezViewModel: MoviezViewModel,
    movieDetail: MovieDetailUser
) {
    Column {
        Text(text = movieDetail.titleEng)
        Spacer(modifier = Modifier.height(10.dp))
        Text(text = movieDetail.descriptionFull)
    }
}
