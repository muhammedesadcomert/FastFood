package com.muhammedesadcomert.shopping.data.repository

import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.common.util.extension.safeApiCall
import com.muhammedesadcomert.shopping.data.mapper.CategoryDtoMapper
import com.muhammedesadcomert.shopping.data.remote.ApiService
import com.muhammedesadcomert.shopping.domain.model.Category
import com.muhammedesadcomert.shopping.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val apiService: ApiService,
    private val categoryDtoMapper: CategoryDtoMapper,
) : CategoryRepository {

    override suspend fun getCategories(): Resource<List<Category>, String> =
        apiService.getCategories().safeApiCall { categoryDtoMapper.toDomainList(it.categories) }
}