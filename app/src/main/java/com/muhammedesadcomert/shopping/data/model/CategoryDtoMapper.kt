package com.muhammedesadcomert.shopping.data.model

import com.muhammedesadcomert.shopping.domain.model.Category
import com.muhammedesadcomert.shopping.domain.util.DomainMapper
import javax.inject.Inject

class CategoryDtoMapper @Inject constructor() : DomainMapper<CategoryData, Category> {
    override fun mapToDomainModel(model: CategoryData): Category =
        Category(
            name = model.name,
            icon = model.icon
        )

    fun toDomainList(initial: List<CategoryData>): List<Category> =
        initial.map(this::mapToDomainModel)
}