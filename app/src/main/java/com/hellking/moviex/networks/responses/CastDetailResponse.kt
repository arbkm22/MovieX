package com.hellking.moviex.networks.responses

import com.google.gson.annotations.SerializedName

data class CastDetailResponse(
    @SerializedName("name") val name: String,
    @SerializedName("birthday") val birthday: String?,
    @SerializedName("biography") val biography: String,
    @SerializedName("place_of_birth") val place_of_birth: String?,
    @SerializedName("gender") val gender: Int,
    @SerializedName("id") val id: Int,
    @SerializedName("imdb_id") val imdb_id: String
)
