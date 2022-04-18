package com.hellking.moviex.networks.responses

import com.google.gson.annotations.SerializedName

data class MovieDetailResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("url") val url: String,
    @SerializedName("imdb_code") val imdb_code: String?,
    @SerializedName("title_eng") val title_eng: String?,
    @SerializedName("year") val year: Int?,
    @SerializedName("rating") val rating: Float?,
    @SerializedName("genres") val genres: List<String>?,
    @SerializedName("large_cover_image") val large_cover_image: String?,
    @SerializedName("medium_cover_image") val medium_cover_image: String?,
    @SerializedName("download_count") val download_count: Int?,
    @SerializedName("like_count") val like_count: Int?,
    @SerializedName("cast") val cast: List<Cast>?,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("description_full") val description_full: String?,
    @SerializedName("yt_trailer_code") val yt_trailer_code: String?,
    @SerializedName("language") val language: String?,
    @SerializedName("background_image_original") val background_image_original: String?,
    @SerializedName("lsi1") val lsi1: String?,
    @SerializedName("lsi2") val lsi2: String?,
    @SerializedName("lsi3") val lsi3: String?,
    @SerializedName("torrents") val torrents: List<Torrent>
)
