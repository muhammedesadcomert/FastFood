package com.muhammedesadcomert.shopping.data.repository

import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.common.util.safeApiCall
import com.muhammedesadcomert.shopping.data.model.CategoryDtoMapper
import com.muhammedesadcomert.shopping.data.remote.ApiService
import com.muhammedesadcomert.shopping.domain.model.Category
import com.muhammedesadcomert.shopping.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val mapper: CategoryDtoMapper,
) : ProductRepository {

    override suspend fun getCategories(): Resource<List<Category>, String> =
        apiService.getCategories()
            .safeApiCall(transform = { mapper.toDomainList(it.categories) })

//    override suspend fun getProducts(categoryId: String, sort: String): Resource<ProductsApiModel> =
//        safeApiCall { apiService.getProducts(categoryId, sort) }
//
//    override suspend fun getSingleProductDetail(productId: String): Resource<ProductApiModel> =
//        safeApiCall { apiService.getSingleProductDetail(productId) }
}