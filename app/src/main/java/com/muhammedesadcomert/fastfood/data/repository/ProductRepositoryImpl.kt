package com.muhammedesadcomert.fastfood.data.repository

import com.muhammedesadcomert.fastfood.data.mapper.ProductDtoMapper
import com.muhammedesadcomert.fastfood.data.mapper.ProductListDtoMapper
import com.muhammedesadcomert.fastfood.data.remote.ApiService
import com.muhammedesadcomert.fastfood.domain.model.Product
import com.muhammedesadcomert.fastfood.domain.repository.ProductRepository
import com.muhammedesadcomert.fastfood.util.Resource
import com.muhammedesadcomert.fastfood.util.extension.safeApiCall

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
