package com.hellking.moviex.networks.services

import com.hellking.moviex.networks.responses.ActorImage
import com.hellking.moviex.networks.responses.CastDetailResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {
    @GET("actor_details")
    suspend fun actor_details(
        @Query("id") id: String
    ): CastDetailResponse

    @GET("actor_pics")
    suspend fun actor_pics(
        @Query("id") id: String
    ): ActorImage
}