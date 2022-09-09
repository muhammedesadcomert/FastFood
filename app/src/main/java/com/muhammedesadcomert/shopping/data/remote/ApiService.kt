package com.muhammedesadcomert.shopping.data.remote

import com.muhammedesadcomert.shopping.ui.home.model.CategoryApiModel
import com.muhammedesadcomert.shopping.ui.home.model.ProductsApiModel
import com.muhammedesadcomert.shopping.ui.home.productdetail.model.ProductApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("categories")
    suspend fun getCategories(): Response<CategoryApiModel>

    @GET("products/advanced-filtered")
    suspend fun getProducts(
        @Query("categoryId") categoryId: String,
        @Query("sort") sort: String,
    ): Response<ProductsApiModel>

    @GET("products/{productId}")
    suspend fun getSingleProductDetail(
        @Path("productId") productId: String,
    ): Response<ProductApiModel>
}