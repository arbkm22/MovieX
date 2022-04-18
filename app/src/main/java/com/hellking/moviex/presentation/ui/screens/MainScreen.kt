package com.hellking.moviex.presentation.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.hellking.moviex.presentation.components.NavGraph
import com.hellking.moviex.presentation.viewModels.MoviezViewModel

@Composable
fun MainScreen(
    moviezViewModel: MoviezViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    Scaffold {
        NavGraph(navController = navController, moviezViewModel = moviezViewModel)
    }
}