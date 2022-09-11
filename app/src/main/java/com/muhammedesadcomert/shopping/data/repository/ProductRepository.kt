package com.muhammedesadcomert.shopping.data.repository

import com.muhammedesadcomert.shopping.common.base.BaseRepository
import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.data.remote.ApiService
import com.muhammedesadcomert.shopping.ui.home.model.CategoryApiModel
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService) : BaseRepository() {
    suspend fun getCategories(): Resource<CategoryApiModel> =
        safeApiCall { apiService.getCategories() }
}
