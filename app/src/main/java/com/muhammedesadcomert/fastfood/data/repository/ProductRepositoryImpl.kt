package com.muhammedesadcomert.fastfood.data.repository

import com.muhammedesadcomert.fastfood.data.mapper.ProductDtoMapper
import com.muhammedesadcomert.fastfood.data.mapper.ProductListDtoMapper
import com.muhammedesadcomert.fastfood.data.remote.ShopirollerApi
import com.muhammedesadcomert.fastfood.domain.model.Product
import com.muhammedesadcomert.fastfood.domain.repository.ProductRepository
import com.muhammedesadcomert.fastfood.util.Resource
import com.muhammedesadcomert.fastfood.util.extension.safeApiCall

class ProductRepositoryImpl(
    private val shopirollerApi: ShopirollerApi,
    private val productListDtoMapper: ProductListDtoMapper,
    private val productDtoMapper: ProductDtoMapper,
) : ProductRepository {

    override suspend fun getProducts(
        categoryId: String,
        sortingType: String,
    ): Resource<List<Product>, String> = shopirollerApi.getProducts(categoryId, sortingType)
        .safeApiCall { productListDtoMapper.toDomainList(it.products) }

    override suspend fun getSingleProductDetail(productId: String): Resource<Product, String> =
        shopirollerApi.getSingleProductDetail(productId)
            .safeApiCall { productDtoMapper.mapToDomainModel(it.product!!) }
}
