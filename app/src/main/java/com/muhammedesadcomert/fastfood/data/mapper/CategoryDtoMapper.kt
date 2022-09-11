package com.muhammedesadcomert.fastfood.data.mapper

import com.muhammedesadcomert.fastfood.data.model.CategoryData
import com.muhammedesadcomert.fastfood.domain.model.Category
import com.muhammedesadcomert.fastfood.domain.util.DomainMapper
import javax.inject.Inject

class CategoryDtoMapper @Inject constructor() : DomainMapper<CategoryData, Category> {
    override fun mapToDomainModel(model: CategoryData): Category =
        Category(
            id = model.categoryId,
            name = model.name,
            icon = model.icon
        )

    fun toDomainList(initial: List<CategoryData>): List<Category> =
        initial.map(this::mapToDomainModel)
}
