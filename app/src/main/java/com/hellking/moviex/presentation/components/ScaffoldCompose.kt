package com.hellking.moviex.presentation.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.hellking.moviex.presentation.viewModels.MoviezViewModel

@ExperimentalCoilApi
@ExperimentalMaterialApi
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