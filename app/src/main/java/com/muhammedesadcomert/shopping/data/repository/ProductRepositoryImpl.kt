package com.muhammedesadcomert.shopping.data.repository

import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.common.util.extension.safeApiCall
import com.muhammedesadcomert.shopping.data.mapper.ProductDtoMapper
import com.muhammedesadcomert.shopping.data.mapper.ProductListDtoMapper
import com.muhammedesadcomert.shopping.data.remote.ApiService
import com.muhammedesadcomert.shopping.domain.model.Product
import com.muhammedesadcomert.shopping.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val apiService: ApiService,
    private val productListDtoMapper: ProductListDtoMapper,
    private val productDtoMapper: ProductDtoMapper
) : ProductRepository {

    override suspend fun getProducts(
        categoryId: String,
        sort: String
    ): Resource<List<Product>, String> = apiService.getProducts(categoryId, sort)
        .safeApiCall { productListDtoMapper.toDomainList(it.products) }

    override suspend fun getSingleProductDetail(productId: String): Resource<Product, String> =
        apiService.getSingleProductDetail(productId)
            .safeApiCall { productDtoMapper.mapToDomainModel(it.product!!) }
}
