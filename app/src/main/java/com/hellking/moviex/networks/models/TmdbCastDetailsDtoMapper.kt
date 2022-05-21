package com.hellking.moviex.networks.models

import com.hellking.moviex.domain.models.CastDetailsUser
import com.hellking.moviex.domain.utils.DomainMapper
import com.hellking.moviex.networks.responses.CastDetailResponse

class TmdbCastDetailsDtoMapper: DomainMapper<CastDetailResponse, CastDetailsUser> {
    override fun mapToDomain(entity: CastDetailResponse): CastDetailsUser {
        return CastDetailsUser(
            birthday = entity.birthday?: "",
            name = entity.name,
            biography = entity.biography,
            placeOfBirth = entity.place_of_birth?: "",
            gender = entity.gender,
            id = entity.id,
            imdbId = entity.imdb_id
        )
    }

    override fun mapToDomainList(entities: MutableList<CastDetailResponse>): List<CastDetailsUser> {
        return entities.map {
            mapToDomain(it)
        }
    }
}