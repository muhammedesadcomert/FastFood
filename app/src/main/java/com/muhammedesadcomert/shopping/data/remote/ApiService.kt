package com.muhammedesadcomert.shopping.data.remote

import com.muhammedesadcomert.shopping.ui.home.model.CategoryApiModel
import com.muhammedesadcomert.shopping.ui.home.model.ProductApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories")
    suspend fun getCategories(): Response<CategoryApiModel>

    @GET("products/advanced-filtered")
    suspend fun getProducts(
        @Query("categoryId") categoryId: String,
        @Query("sort") sort: String,
    ): Response<ProductApiModel>
}