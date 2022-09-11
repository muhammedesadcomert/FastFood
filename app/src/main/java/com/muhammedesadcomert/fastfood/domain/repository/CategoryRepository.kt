package com.muhammedesadcomert.fastfood.domain.repository

import com.muhammedesadcomert.fastfood.domain.model.Category
import com.muhammedesadcomert.fastfood.util.Resource

interface CategoryRepository {

    suspend fun getCategories(): Resource<List<Category>, String>
}
