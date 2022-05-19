package com.hellking.moviex.presentation.ui.screens

import android.os.Build
import android.text.Html
import android.util.Log
import android.widget.Space
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.hellking.moviex.domain.models.MovieDetailUser
import com.hellking.moviex.presentation.components.GenreChipGroup
import com.hellking.moviex.presentation.viewModels.MoviezViewModel
import com.hellking.moviex.utils.Resource

@ExperimentalCoilApi
@Composable
fun DetailScreen(
    navController: NavController,
    moviezViewModel: MoviezViewModel,
    //movieId: Int
    name: String,
    url: String
) {
    Log.d("name", "$name")
    val movieIdVar = remember {
        mutableStateOf<Resource<MovieDetailUser>>(Resource.Empty())
    }
    val movieNameVar = remember {
        mutableStateOf<Resource<MovieDetailUser>>(Resource.Empty())
    }
    val urlVar = remember {
        mutableStateOf<Resource<MovieDetailUser>>(Resource.Empty())
    }
    when (movieNameVar.value) {
        is Resource.Empty -> {
            // moviezViewModel.getMovieDetail(movieId)
            moviezViewModel.getMovieDetailv2(name, url)
            //movieIdVar.value = moviezViewModel.movieDetailState.value
            movieNameVar.value = moviezViewModel.movieDetailState.value
            urlVar.value = moviezViewModel.movieDetailState.value
        }
        is Resource.Error -> {
            Log.d("DetailScr->movieDetail", "DetailScreen me lafda he ${movieNameVar.value.message}")
            Text(text = "DetailScreen me error he")
        }
        is Resource.Loading -> {
            CircularProgressIndicator()
            movieNameVar.value = moviezViewModel.movieDetailState.value
            urlVar.value = moviezViewModel.movieDetailState.value
        }
        is Resource.Success -> {
            val tempContent = movieNameVar.value.data
            DetailScreenSuccess(
                navController = navController,
                moviezViewModel = moviezViewModel,
                movieDetail = tempContent!!
            )
        }
    }
}


@ExperimentalCoilApi
@Composable
fun DetailScreenTopLayout(
    movieDetail: MovieDetailUser,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = Modifier
            .height(600.dp)
            .fillMaxWidth()
    ) {
        val painter = rememberImagePainter(data = movieDetail.largeCoverImage)
        val desc = movieDetail.titleEng + " Poster"
        Image(
            modifier = modifier.fillMaxWidth(),
            painter = painter,
            contentDescription = desc,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 900f
                    )
                )
        )
    }
}

private const val MINIMIZED_MAX_LINES = 2

@Composable
fun TitleDesc(
    movieDetail: MovieDetailUser
) {
    var desc = movieDetail.descriptionFull
    desc = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        Html.fromHtml(desc, Html.FROM_HTML_MODE_LEGACY).toString()
    } else {
        Html.fromHtml(desc).toString()
    }
    var isExpanded by remember { mutableStateOf(false) }
    val textLayoutResultState = remember { mutableStateOf<TextLayoutResult?>(null) }
    var isClickable by remember { mutableStateOf(false) }
    var finalText by remember { mutableStateOf(desc) }

    val textLayoutResult = textLayoutResultState.value
    LaunchedEffect(textLayoutResult) {
        if (textLayoutResult == null) return@LaunchedEffect
    }

    if (textLayoutResult != null) {
        when {
            isExpanded -> {
                finalText = desc
            }
            !isExpanded && textLayoutResult.hasVisualOverflow -> {
                val lastCharIndex = textLayoutResult.getLineEnd(MINIMIZED_MAX_LINES - 1)
                val showMoreString = "... Show More"
                val adjustedText = desc
                    .substring(startIndex = 0, endIndex = lastCharIndex)
                    .dropLast(showMoreString.length)
                    .dropLastWhile { it == ' ' || it == '.' }
                finalText = adjustedText

                isClickable = true
            }
        }
    }

    Text(
        text = movieDetail.titleEng,
        fontSize = 28.sp,
        color = Color.White,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
        text = buildAnnotatedString {
            append(finalText)
            withStyle(
                style = SpanStyle(
                    color = Color.Red,
                    fontSize = 14.sp
                )
            ) {
                if (isExpanded) append(" Show Less") else append(" ...Show More")
            }
        },
        maxLines = if (isExpanded) Int.MAX_VALUE else MINIMIZED_MAX_LINES,
        onTextLayout = { textLayoutResultState.value = it },
        modifier = Modifier
            .clickable(enabled = isClickable) { isExpanded = !isExpanded }
            .animateContentSize()
            .padding(horizontal = 16.dp)
    )
}


@ExperimentalCoilApi
@Composable
fun DetailScreenSuccess(
    navController: NavController,
    moviezViewModel: MoviezViewModel,
    movieDetail: MovieDetailUser
) {
    LazyColumn(
        modifier = Modifier.background(Color.Black)
    ) {
        item {
            DetailScreenTopLayout(movieDetail = movieDetail)
        }
        item {
            GenreChipGroup(movieDetail = movieDetail)
        }
        item {
            TitleDesc(movieDetail = movieDetail)
        }
    }
}
