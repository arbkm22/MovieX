package com.hellking.moviex.networks.responses

import com.google.gson.annotations.SerializedName

data class MoviesListResponse(
    //@SerializedName("id") val id: Int,
    @SerializedName("url")val url: String,
    //@SerializedName("imdb_code")val imdb_code: String?,
    @SerializedName("title_eng")val title_eng: String?,
    @SerializedName("year")val year: Int?,
    @SerializedName("medium_cover_image")val medium_cover_image: String?
    //@SerializedName("rating")val rating: Float?,
    //@SerializedName("genre")val genre: List<String>?,
    //@SerializedName("large_cover_image")val large_cover_image: String?
)

