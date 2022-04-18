package com.hellking.moviex.networks.responses

data class Cast(
    val name: String,
    val character_name: String,
    val url_small_image: String?,
    val imdb_code: String?
)
