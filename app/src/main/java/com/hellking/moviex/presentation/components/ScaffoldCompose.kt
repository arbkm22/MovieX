package com.hellking.moviex.presentation.components

import androidx.compose.foundation.background
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
        modifier = Modifier.background(Color.Black),
        topBar = { TopBar() },
    ) {
        ContentLayer(
            navController = navController,
            moviezViewModel = moviezViewModel
        )
    }
}