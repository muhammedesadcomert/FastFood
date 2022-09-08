package com.muhammedesadcomert.shopping.data.remote

import com.muhammedesadcomert.shopping.ui.home.model.CategoryApiModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("categories")
    suspend fun getCategories(): Response<CategoryApiModel>
}