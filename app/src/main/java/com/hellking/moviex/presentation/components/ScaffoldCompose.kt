package com.hellking.moviex.presentation.components

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.hellking.moviex.presentation.viewModels.MoviezViewModel

@Composable
fun ScaffoldCompose(
    navController: NavController,
    moviezViewModel: MoviezViewModel
) {
    Scaffold(
        topBar = { TopBar() },
    ) {
        ContentLayer(
            navController = navController,
            moviezViewModel = moviezViewModel
        )
    }
}