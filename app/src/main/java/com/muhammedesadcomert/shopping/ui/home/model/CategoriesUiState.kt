package com.muhammedesadcomert.shopping.ui.home.model

import com.muhammedesadcomert.shopping.domain.model.Category

data class CategoriesUiState(
    val categories: List<Category> = arrayListOf(),
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
) {
    companion object {
        fun initial() = CategoriesUiState()
    }
}
