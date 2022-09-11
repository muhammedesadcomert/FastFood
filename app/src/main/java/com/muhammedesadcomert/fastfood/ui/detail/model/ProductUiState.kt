package com.muhammedesadcomert.fastfood.ui.detail.model

import com.muhammedesadcomert.fastfood.domain.model.Product

data class ProductUiState(
    val product: Product? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false
) {
    companion object {
        fun initial() = ProductUiState()
    }
}
