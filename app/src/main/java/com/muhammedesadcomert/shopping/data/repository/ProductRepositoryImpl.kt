package com.muhammedesadcomert.shopping.data.repository

import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.common.util.safeApiCall
import com.muhammedesadcomert.shopping.data.model.CategoryDtoMapper
import com.muhammedesadcomert.shopping.data.model.ProductDtoMapper
import com.muhammedesadcomert.shopping.data.remote.ApiService
import com.muhammedesadcomert.shopping.domain.model.Category
import com.muhammedesadcomert.shopping.domain.model.Product
import com.muhammedesadcomert.shopping.domain.repository.ProductRepository
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val categoryDtoMapper: CategoryDtoMapper,
    private val productDtoMapper: ProductDtoMapper,
) : ProductRepository {

    override suspend fun getCategories(): Resource<List<Category>, String> =
        apiService.getCategories()
            .safeApiCall { categoryDtoMapper.toDomainList(it.categories) }

    override suspend fun getProducts(
        categoryId: String,
        sort: String,
    ): Resource<List<Product>, String> = apiService.getProducts(categoryId, sort)
        .safeApiCall { productDtoMapper.toDomainList(it.products) }

//    override suspend fun getSingleProductDetail(productId: String): Resource<ProductApiModel> =
//        safeApiCall { apiService.getSingleProductDetail(productId) }
}