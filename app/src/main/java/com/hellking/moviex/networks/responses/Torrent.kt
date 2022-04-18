package com.hellking.moviex.networks.responses

data class Torrent(
    val url: String,
    val hash: String,
    val quality: String,
    val type: String?,
    val seeds: Int,
    val peers: Int,
    val size: String
)
