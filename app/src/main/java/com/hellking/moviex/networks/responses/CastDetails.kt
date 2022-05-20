package com.hellking.moviex.networks.responses

data class CastDetails(
    val name: String,
    val birthday: String?,
    val biography: String,
    val placeOfBirth: String?,
    val gender: Int,
    val id: Int,
    val imdbId: String
)
