package com.hellking.moviex.networks.models

import com.hellking.moviex.domain.models.MovieListUser
import com.hellking.moviex.domain.utils.DomainMapper
import com.hellking.moviex.networks.responses.MoviesListResponse

class YtsMoviesListDtoMapper: DomainMapper<List<MoviesListResponse>, List<MovieListUser>> {
    override fun mapToDomain(entity: List<MoviesListResponse>): List<MovieListUser> {
        return entity.map {
            MovieListUser(
                //id = it.id,
                url = it.url,
                //imdbCode = it.imdb_code?: "",
                titleEng = it.title_eng?: "",
                year = it.year?: 0,
                //rating = it.rating?: 0f,
                //genre = it.genre?: listOf(),
                //largeCoverImage = it.large_cover_image?: "",
                mediumCoverImage = it.medium_cover_image?: ""
            )
        }
    }

    override fun mapToDomainList(entities: MutableList<List<MoviesListResponse>>): List<List<MovieListUser>> {
        return entities.map {
            mapToDomain(it)
        }
    }

}
