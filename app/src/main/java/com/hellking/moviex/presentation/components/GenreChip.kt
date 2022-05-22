package com.hellking.moviex.presentation.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hellking.moviex.domain.models.MovieDetailUser

@Composable
fun GenreChip(
    genre: String
) {
    Surface(
        modifier = Modifier.padding(6.dp),
        elevation = 8.dp,
        shape = RoundedCornerShape(18.dp),
        color = Color.DarkGray
    ) {
        Row {
            Text(
                text = genre,
                color = Color.White,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@Composable
fun GenreChipGroup(
    movieDetail: MovieDetailUser
) {
    LazyRow(
        modifier = Modifier.padding(start = 10.dp)
    ) {
        movieDetail.genres.forEach() { genre ->
            item {
                GenreChip(genre = genre)
            }
        }
    }
}