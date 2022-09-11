package com.muhammedesadcomert.fastfood.data.repository

import com.muhammedesadcomert.fastfood.common.util.Resource
import com.muhammedesadcomert.fastfood.common.util.extension.safeApiCall
import com.muhammedesadcomert.fastfood.data.mapper.CategoryDtoMapper
import com.muhammedesadcomert.fastfood.data.remote.ApiService
import com.muhammedesadcomert.fastfood.domain.model.Category
import com.muhammedesadcomert.fastfood.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val apiService: ApiService,
    private val categoryDtoMapper: CategoryDtoMapper,
) : CategoryRepository {

    override suspend fun getCategories(): Resource<List<Category>, String> =
        apiService.getCategories().safeApiCall { categoryDtoMapper.toDomainList(it.categories) }
}
