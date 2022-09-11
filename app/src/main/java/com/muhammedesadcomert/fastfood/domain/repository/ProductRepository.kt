package com.muhammedesadcomert.fastfood.domain.repository

import com.muhammedesadcomert.fastfood.common.util.Resource
import com.muhammedesadcomert.fastfood.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(categoryId: String, sort: String): Resource<List<Product>, String>

    suspend fun getSingleProductDetail(productId: String): Resource<Product, String>
}
