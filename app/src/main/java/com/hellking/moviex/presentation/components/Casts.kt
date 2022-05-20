package com.hellking.moviex.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.hellking.moviex.domain.models.MovieDetailUser
import com.hellking.moviex.networks.responses.Cast

@Composable
fun CastCard(
    cast: Cast
) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .width(120.dp)
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(cast.url_small_image)
                .crossfade(true)
                .build(),
            contentDescription = "${cast.name}'s photo",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
        )
    }
}

@Composable
fun CastRow(
    movieDetail: MovieDetailUser
) {
    Column(
        modifier = Modifier
            .background(Color.Black)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Cast",
            fontSize = 28.sp
        )
        Spacer(modifier = Modifier.height(8.dp))
        LazyRow(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
                .height(400.dp)
        ) {
            movieDetail.cast.forEach { actor ->
                item {
                    CastCard(cast = actor)
                }
            }
        }
    }
}