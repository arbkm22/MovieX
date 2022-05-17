package com.hellking.moviex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.core.view.WindowCompat
import coil.annotation.ExperimentalCoilApi
import com.hellking.moviex.presentation.ui.screens.MainScreen
import com.hellking.moviex.presentation.ui.theme.MoviezTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalCoilApi
@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            MoviezTheme {
                MainScreen()
            }
        }
    }
}
