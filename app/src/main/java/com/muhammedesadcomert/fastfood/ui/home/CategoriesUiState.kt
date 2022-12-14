package com.muhammedesadcomert.fastfood.ui.home

import com.muhammedesadcomert.fastfood.domain.model.Category

data class CategoriesUiState(
    val categories: List<Category> = arrayListOf(),
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
) {
    companion object {
        fun initial() = CategoriesUiState()
    }
}
