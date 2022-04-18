package com.hellking.moviex.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.hellking.moviex.presentation.components.NavigationRoutes
import com.hellking.moviex.presentation.components.ScaffoldCompose
import com.hellking.moviex.presentation.viewModels.MoviezViewModel
import com.hellking.moviex.utils.Resource

@Composable
fun HomeScreen(
    navController: NavHostController,
    moviezViewModel: MoviezViewModel
) {
    val movieList = moviezViewModel.movieListState.value
    when (movieList) {
        // is Resource.Empty -> moviezViewModel.getMovies(1)
        is Resource.Empty -> moviezViewModel.getLatestMovies()
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

@Composable
fun HomeScreenSuccess(
    navController: NavHostController,
    moviezViewModel: MoviezViewModel
) {
    val movieList = moviezViewModel.movieListState.value.data
    ScaffoldCompose()
}