package com.muhammedesadcomert.shopping.domain.repository

import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.domain.model.Category
import com.muhammedesadcomert.shopping.domain.model.Product

interface ProductRepository {
    suspend fun getCategories(): Resource<List<Category>, String>

    suspend fun getProducts(categoryId: String, sort: String): Resource<List<Product>, String>

    suspend fun getSingleProductDetail(productId: String): Resource<Product, String>
}