package com.muhammedesadcomert.shopping.ui.home.model

import com.muhammedesadcomert.shopping.domain.model.Product

data class ProductsUiState(
    val products: List<Product> = arrayListOf(),
    val errorMessage: String? = null,
    val isLoading: Boolean = false,
) {
    companion object {
        fun initial() = ProductsUiState()
    }
}
