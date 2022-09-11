package com.muhammedesadcomert.shopping.ui.home.model

import com.muhammedesadcomert.shopping.domain.model.Product

data class ProductUiState(
    val product: Product? = null,
    val errorMessage: String? = null,
    val isLoading: Boolean = false
) {
    companion object {
        fun initial() = ProductUiState()
    }
}
