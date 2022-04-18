package com.hellking.moviex.domain.utils

interface DomainMapper<Entity,DomainModel>{
    fun mapToDomain(entity: Entity):DomainModel

    fun mapToDomainList(entities: MutableList<Entity>): List<DomainModel>
}