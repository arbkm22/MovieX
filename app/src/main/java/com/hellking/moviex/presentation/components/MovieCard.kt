package com.hellking.moviex.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.hellking.moviex.presentation.viewModels.MoviezViewModel

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun MovieCard(
    navController: NavController,
    title: String,
    url: String,
    year: Int,
    mci: String
) {
    Card(
        onClick = {
            navController.navigate(
                NavigationRoutes.Detail.passNameAndUrl(title, url)
            ) {
                popUpTo(route = NavigationRoutes.Home.route)
                launchSingleTop = true
            }
        },
        modifier = Modifier
            .width(175.dp)
            .height(260.dp),
        elevation = 12.dp,
        shape = RoundedCornerShape(8.dp)
    ) {
        val painter = rememberImagePainter(
            data = mci,
            builder = {

            }
        )
        Image(
            painter = painter,
            contentDescription = "image"
        ) /*
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
           */
    }
}
/*
@ExperimentalCoilApi
@ExperimentalMaterialApi
@Preview
@Composable
fun Prev2() {
    MovieCard(
        "Spider-Man: No way Home",
        "",
        2022,
        "https://img.yts.mx/assets/images/movies/spider_man_no_way_home_2021/medium-cover.jpg")
}
*/