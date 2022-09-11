package com.muhammedesadcomert.fastfood.domain.repository

import com.muhammedesadcomert.fastfood.common.util.Resource
import com.muhammedesadcomert.fastfood.domain.model.Category

interface CategoryRepository {

    suspend fun getCategories(): Resource<List<Category>, String>
}
