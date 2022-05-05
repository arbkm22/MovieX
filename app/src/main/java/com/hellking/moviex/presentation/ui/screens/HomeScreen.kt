package com.hellking.moviex.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.hellking.moviex.presentation.components.NavigationRoutes
import com.hellking.moviex.presentation.components.ScaffoldCompose
import com.hellking.moviex.presentation.viewModels.MoviezViewModel
import com.hellking.moviex.utils.Resource

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    moviezViewModel: MoviezViewModel
) {
    /* initial tem
    val movieList = moviezViewModel.movieListState.value
    when (movieList) {
        // is Resource.Empty -> moviezViewModel.getMovies(1)
        is Resource.Empty -> {
            moviezViewModel.getLatestMovies()
        }
        is Resource.Error -> {
            Log.d("HomeScreen->movieList", "HomeScreen me lafda he ${movieList.message}")
            Text("Error he vro")
        }
        is Resource.Loading -> {
            CircularProgressIndicator()
        }
        is Resource.Success -> {
            HomeScreenSuccess(navController = navController, moviezViewModel = moviezViewModel)
        }
    } */

    val latestMovies = moviezViewModel.latestMoviesState.value
    val popularMovies = moviezViewModel.popularMoviesState.value
    val likedMovies = moviezViewModel.likedMoviesState.value

    if (
        latestMovies is Resource.Empty ||
        popularMovies is Resource.Empty ||
        likedMovies is Resource.Empty
    ) {
        if (latestMovies is Resource.Empty) {
            moviezViewModel.getLatestMovies()
        }
        if (popularMovies is Resource.Empty) {
            moviezViewModel.getPopularMovies()
        }
        if (likedMovies is Resource.Empty) {
            moviezViewModel.getMostLikedMovies()
        }
    }
    else if (
        latestMovies is Resource.Error ||
        popularMovies is Resource.Error ||
        likedMovies is Resource.Error
    ) {
        if (latestMovies is Resource.Error) {
            Log.d("HmScrn->latestMovies", "HomeScreen me lafda he ${latestMovies.message}")
            Text("Error he vro")
        }
        if (popularMovies is Resource.Error) {
            Log.d("HmScrn->popularMovies", "HomeScreen me lafda he ${popularMovies.message}")
            Text("Error he vro")
        }
        if (likedMovies is Resource.Error) {
            Log.d("HmScrn->likedMovies", "HomeScreen me lafda he ${likedMovies.message}")
            Text("Error he vro")
        }
    }
    else if (
        latestMovies is Resource.Success &&
        popularMovies is Resource.Success &&
        likedMovies is Resource.Success
    ) {
        if (latestMovies is Resource.Success) {
            HomeScreenSuccess(navController = navController, moviezViewModel = moviezViewModel)
        }
        if (popularMovies is Resource.Success) {
            HomeScreenSuccess(navController = navController, moviezViewModel = moviezViewModel)
        }
        if (likedMovies is Resource.Success) {
            HomeScreenSuccess(navController = navController, moviezViewModel = moviezViewModel)
        }
    }
    else if (
        latestMovies is Resource.Loading ||
        popularMovies is Resource.Loading ||
        likedMovies is Resource.Loading
    ) {
        if (latestMovies is Resource.Loading) {
            CircularProgressIndicator()
        }
        if (popularMovies is Resource.Loading) {
            CircularProgressIndicator()
        }
        if (likedMovies is Resource.Loading) {
            CircularProgressIndicator()
        }
    }

}

//@Composable
//fun HomeScreenSuccess(
//    navController: NavHostController,
//    moviezViewModel: MoviezViewModel
//) {
//    val movieList = moviezViewModel.movieListState.value.data
//    LazyColumn() {
//        movieList?.forEach { movies ->
//            item {
//                Text(
//                    text = movies.titleEng,
//                    modifier = Modifier.clickable {
//                        navController.navigate(
//                            NavigationRoutes.Detail.passNameAndUrl(movies.titleEng, movies.url)
//                        ) {
//                            popUpTo(route = NavigationRoutes.Home.route)
//                            launchSingleTop = true
//                        }
//                    }
//                )
//                Spacer(modifier = Modifier.height(10.dp))
//            }
//        }
//    }
//}

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun HomeScreenSuccess(
    navController: NavHostController,
    moviezViewModel: MoviezViewModel
) {
    // val movieList = moviezViewModel.movieListState.value.data
    val latestMovies = moviezViewModel.latestMoviesState.value.data
    val popularMovies = moviezViewModel.latestMoviesState.value.data
    val likedMovies = moviezViewModel.latestMoviesState.value.data
    ScaffoldCompose(navController, moviezViewModel)
}