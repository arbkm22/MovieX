package com.hellking.moviex.domain.models

data class CastDetailsUser(
    val name: String,
    val birthday: String,
    val biography: String,
    val placeOfBirth: String,
    val gender: Int,
    val id: Int,
    val imdbId: String
)
