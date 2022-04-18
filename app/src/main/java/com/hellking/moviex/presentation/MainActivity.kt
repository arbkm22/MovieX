package com.hellking.moviex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.hellking.moviex.presentation.ui.screens.MainScreen
import com.hellking.moviex.presentation.ui.theme.MoviezTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoviezTheme {
                MainScreen()
            }
        }
    }
}
