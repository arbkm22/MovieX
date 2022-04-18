package com.hellking.moviex.domain.models

import com.hellking.moviex.networks.responses.Cast
import com.hellking.moviex.networks.responses.Torrent


data class MovieDetailUser(
    val id: Int,
    val url: String,
    val imdbCode: String,
    val titleEng: String,
    val year: Int,
    val rating: Float,
    val genres: List<String>,
    val largeCoverImage: String,
    val mediumCoverImage: String,
    val downloadCount: Int,
    val likeCount: Int,
    val cast: List<Cast>,
    val runtime: Int,
    val descriptionFull: String,
    val ytTrailerCode: String,
    val language: String,
    val backgroundImageOriginal: String,
    val lsi1: String,
    val lsi2: String,
    val lsi3: String,
    val torrents: List<Torrent>
)
