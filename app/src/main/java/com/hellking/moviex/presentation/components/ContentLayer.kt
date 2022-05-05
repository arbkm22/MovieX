package com.hellking.moviex.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.hellking.moviex.presentation.viewModels.MoviezViewModel

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun ContentLayer(
    navController: NavController,
    moviezViewModel: MoviezViewModel
) {
    /*
    val movieList = moviezViewModel.movieListState.value.data
    LazyColumn() {
        movieList?.forEach { movies ->
            item {
                Text(
                    text = movies.titleEng,
                    modifier = Modifier.clickable {
                        navController.navigate(
                            NavigationRoutes.Detail.passNameAndUrl(movies.titleEng, movies.url)
                        ) {
                            popUpTo(route = NavigationRoutes.Home.route)
                            launchSingleTop = true
                        }
                    }
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    } */
    val latestMovies = moviezViewModel.latestMoviesState.value.data
    val popularMovies = moviezViewModel.popularMoviesState.value.data
    val likedMovies = moviezViewModel.likedMoviesState.value.data
    Column {
        // Latest Movies
        TitleStrip(name = "Latest Movies")
        LazyRow(
            modifier = Modifier.height(280.dp)
        ) {
            latestMovies?.forEach { movies ->
                item{
                    MovieCard(
                        navController = navController,
                        title = movies.titleEng,
                        url = movies.url,
                        year = movies.year,
                        mci = movies.mediumCoverImage
                    )
                }
            }
        } /*
        LazyColumn(
            modifier = Modifier.height(280.dp)
        ) {
            latestMovies?.forEach { movies ->
                item {
                    Text(
                        text = movies.titleEng,
                        modifier = Modifier.clickable {
                            navController.navigate(
                                NavigationRoutes.Detail.passNameAndUrl(
                                    movies.titleEng,
                                    movies.url
                                )
                            ) {
                                popUpTo(route = NavigationRoutes.Home.route)
                                launchSingleTop = true
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        } */
        // Popular Movies
        TitleStrip(name = "Popular Movies")
        LazyRow(
            modifier = Modifier.height(280.dp)
        ) {
            popularMovies?.forEach { movies ->
                item{
                    MovieCard(
                        navController = navController,
                        title = movies.titleEng,
                        url = movies.url,
                        year = movies.year,
                        mci = movies.mediumCoverImage
                    )
                }
            }
        } /*
        LazyColumn(
            modifier = Modifier.height(280.dp)
        ) {
            popularMovies?.forEach { movies ->
                item {
                    Text(
                        text = movies.titleEng,
                        modifier = Modifier.clickable {
                            navController.navigate(
                                NavigationRoutes.Detail.passNameAndUrl(
                                    movies.titleEng,
                                    movies.url
                                )
                            ) {
                                popUpTo(route = NavigationRoutes.Home.route)
                                launchSingleTop = true
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        } */
        // Liked Movies
        TitleStrip(name = "Most Liked")
        LazyRow(
            modifier = Modifier.height(280.dp)
        ) {
            likedMovies?.forEach { movies ->
                item{
                    MovieCard(
                        navController = navController,
                        title = movies.titleEng,
                        url = movies.url,
                        year = movies.year,
                        mci = movies.mediumCoverImage
                    )
                }
            }
        } /*
        LazyColumn(
            modifier = Modifier.height(280.dp)
        ) {
            likedMovies?.forEach { movies ->
                item {
                    Text(
                        text = movies.titleEng,
                        modifier = Modifier.clickable {
                            navController.navigate(
                                NavigationRoutes.Detail.passNameAndUrl(
                                    movies.titleEng,
                                    movies.url
                                )
                            ) {
                                popUpTo(route = NavigationRoutes.Home.route)
                                launchSingleTop = true
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        } */
    }
}

@Composable
fun TitleStrip(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Text(
            text = name,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 8.dp),
            color = Color.White,
        )
    }
}

@Preview
@Composable
fun Prev() {
    TitleStrip(name = "Liked")
}