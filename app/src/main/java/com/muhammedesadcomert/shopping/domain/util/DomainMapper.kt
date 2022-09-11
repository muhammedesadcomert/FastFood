package com.muhammedesadcomert.shopping.domain.util

interface DomainMapper<T, DomainModel> {

    fun mapToDomainModel(model: T): DomainModel
}
