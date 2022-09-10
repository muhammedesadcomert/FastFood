package com.muhammedesadcomert.shopping.data.remote

import com.muhammedesadcomert.shopping.data.model.CategoryDto
import com.muhammedesadcomert.shopping.data.model.ProductDto
import com.muhammedesadcomert.shopping.data.model.ProductListDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("categories")
    suspend fun getCategories(): Response<CategoryDto>

    @GET("products/advanced-filtered")
    suspend fun getProducts(
        @Query("categoryId") categoryId: String,
        @Query("sort") sort: String,
    ): Response<ProductListDto>

    @GET("products/{productId}")
    suspend fun getSingleProductDetail(
        @Path("productId") productId: String,
    ): Response<ProductDto>
}