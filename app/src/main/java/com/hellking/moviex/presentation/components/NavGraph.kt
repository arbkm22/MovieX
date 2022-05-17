package com.hellking.moviex.presentation.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.hellking.moviex.presentation.ui.screens.DetailScreen
import com.hellking.moviex.presentation.ui.screens.HomeScreen
import com.hellking.moviex.presentation.viewModels.MoviezViewModel

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun NavGraph(
    navController: NavHostController,
    moviezViewModel: MoviezViewModel
) {
    NavHost(
        navController = navController,
        startDestination = NavigationRoutes.Home.route
    ) {
        composable(route = NavigationRoutes.Home.route) {
            HomeScreen(navController = navController, moviezViewModel = moviezViewModel)
        }
        composable(
//            route = "${NavigationRoutes.Detail.route}/{movieId}",
//            arguments = listOf(
//                navArgument("movieId") {
//                    type = NavType.StringType
//                    nullable = false
//                }
//            )
            route = NavigationRoutes.Detail.route,
            arguments = listOf(
                navArgument(DETAIL_SCREEN_KEY) {
                    type = NavType.StringType
                },/*
                navArgument("url") {
                    type = NavType.StringType
                    nullable = false
                } */
                navArgument(DETAIL_SCREEN_OP) {
                    type = NavType.StringType
                    defaultValue = ""
                }
            )
        ) { backStackEntry ->
            //val movieId = backStackEntry.arguments!!.getString("movieId")
            val name = backStackEntry.arguments?.getString("name").toString()
            val url = backStackEntry.arguments?.getString("url").toString()
            DetailScreen(
                navController = navController,
                moviezViewModel = moviezViewModel,
                //movieId = movieId!!.toInt()
                name = name,
                url = url
            )
        }
    }
}

