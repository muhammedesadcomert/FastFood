package com.muhammedesadcomert.shopping.domain.repository

import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.domain.model.Category

interface CategoryRepository {

    suspend fun getCategories(): Resource<List<Category>, String>
}