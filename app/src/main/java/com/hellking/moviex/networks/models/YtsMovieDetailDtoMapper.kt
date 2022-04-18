package com.hellking.moviex.networks.models

import com.hellking.moviex.domain.models.MovieDetailUser
import com.hellking.moviex.domain.utils.DomainMapper
import com.hellking.moviex.networks.responses.MovieDetailResponse

class YtsMovieDetailDtoMapper: DomainMapper<MovieDetailResponse, MovieDetailUser> {
    override fun mapToDomain(entity: MovieDetailResponse): MovieDetailUser {
        return MovieDetailUser(
            id = entity.id,
            url = entity.url,
            imdbCode = entity.imdb_code?: "",
            titleEng = entity.title_eng?: "",
            year = entity.year?: 0,
            rating = entity.rating?: 0f,
            genres = entity.genres?: listOf(),
            largeCoverImage = entity.large_cover_image?: "",
            mediumCoverImage = entity.medium_cover_image?: "",
            downloadCount = entity.download_count?: 0,
            likeCount = entity.like_count?: 0,
            cast = entity.cast?: listOf(),
            runtime = entity.runtime?: 0,
            descriptionFull = entity.description_full?: "",
            ytTrailerCode = entity.yt_trailer_code?: "",
            language = entity.language?: "",
            backgroundImageOriginal = entity.background_image_original?: "",
            lsi1 = entity.lsi1?: "",
            lsi2 = entity.lsi2?: "",
            lsi3 = entity.lsi3?: "",
            torrents = entity.torrents
        )
    }

    override fun mapToDomainList(entities: MutableList<MovieDetailResponse>): List<MovieDetailUser> {
        return entities.map {
            mapToDomain(it)
        }
    }
}