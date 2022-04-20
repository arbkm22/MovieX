package com.hellking.moviex.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@ExperimentalMaterialApi
@Composable
fun MovieCard(
    title: String,
    url: String,
    year: Int,
    mci: String
) {
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .width(200.dp)
            .height(400.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(10.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = title,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = year.toString(),
                textAlign = TextAlign.Start,
                color = Color.Gray,
                fontSize = 9.sp
            )
        }

    }
}

@ExperimentalMaterialApi
@Preview
@Composable
fun Prev2() {
    MovieCard("Spider-Man: No way Home", "", 2022, "")
}
