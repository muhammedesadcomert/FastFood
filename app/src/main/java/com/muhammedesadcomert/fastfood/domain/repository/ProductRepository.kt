package com.muhammedesadcomert.fastfood.domain.repository

import com.muhammedesadcomert.fastfood.domain.model.Product
import com.muhammedesadcomert.fastfood.util.Resource

interface ProductRepository {

    suspend fun getProducts(categoryId: String, sortingType: String): Resource<List<Product>, String>

    suspend fun getSingleProductDetail(productId: String): Resource<Product, String>
}
