package com.muhammedesadcomert.fastfood.data.repository

import com.muhammedesadcomert.fastfood.data.mapper.CategoryDtoMapper
import com.muhammedesadcomert.fastfood.data.remote.ShopirollerApi
import com.muhammedesadcomert.fastfood.domain.model.Category
import com.muhammedesadcomert.fastfood.domain.repository.CategoryRepository
import com.muhammedesadcomert.fastfood.util.Resource
import com.muhammedesadcomert.fastfood.util.extension.safeApiCall

class CategoryRepositoryImpl(
    private val shopirollerApi: ShopirollerApi,
    private val categoryDtoMapper: CategoryDtoMapper,
) : CategoryRepository {

    override suspend fun getCategories(): Resource<List<Category>, String> =
        shopirollerApi.getCategories().safeApiCall { categoryDtoMapper.toDomainList(it.categories) }
}
