package com.muhammedesadcomert.shopping.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedesadcomert.shopping.common.util.Constant.DEFAULT_CATEGORY
import com.muhammedesadcomert.shopping.common.util.Constant.DEFAULT_SORT
import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.domain.repository.ProductRepository
import com.muhammedesadcomert.shopping.ui.detail.model.ProductUiState
import com.muhammedesadcomert.shopping.ui.home.model.CategoriesUiState
import com.muhammedesadcomert.shopping.ui.home.model.ProductsUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    private var _categoriesUiState: MutableLiveData<CategoriesUiState> =
        MutableLiveData(CategoriesUiState.initial())
    val categoriesUiState: LiveData<CategoriesUiState> get() = _categoriesUiState

    private var _productsUiState: MutableLiveData<ProductsUiState> =
        MutableLiveData(ProductsUiState.initial())
    val productsUiState: LiveData<ProductsUiState> get() = _productsUiState

    private var _productUiState: MutableLiveData<ProductUiState> =
        MutableLiveData(ProductUiState.initial())
    val productUiState: LiveData<ProductUiState> get() = _productUiState

    init {
        getCategories()
        getProducts()
    }

    private fun getCategories() {
        viewModelScope.launch {
            _categoriesUiState.value = _categoriesUiState.value?.copy(isLoading = true)
            when (val resource = productRepository.getCategories()) {
                is Resource.Failure -> {
                    _categoriesUiState.value = _categoriesUiState.value?.copy(
                        errorMessage = resource.errorMessage,
                        isLoading = false
                    )
                }
                is Resource.Success -> {
                    _categoriesUiState.value = resource.data?.let {
                        _categoriesUiState.value?.copy(
                            categories = it,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    fun getProducts(categoryId: String = DEFAULT_CATEGORY, sort: String = DEFAULT_SORT) {
        viewModelScope.launch {
            _categoriesUiState.value = _categoriesUiState.value?.copy(isLoading = true)
            when (val resource = productRepository.getProducts(categoryId, sort)) {
                is Resource.Failure -> {
                    _productsUiState.value = _productsUiState.value?.copy(
                        errorMessage = resource.errorMessage,
                        isLoading = false
                    )
                }
                is Resource.Success -> {
                    _productsUiState.value = resource.data?.let {
                        _productsUiState.value?.copy(
                            products = it,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }

    fun getSingleProductDetail(productId: String) {
        viewModelScope.launch {
            _productUiState.value = _productUiState.value?.copy(isLoading = true)
            when (val resource = productRepository.getSingleProductDetail(productId)) {
                is Resource.Failure -> {
                    _productUiState.value = _productUiState.value?.copy(
                        errorMessage = resource.errorMessage,
                        isLoading = false
                    )
                }
                is Resource.Success -> {
                    _productUiState.value = resource.data?.let {
                        _productUiState.value?.copy(
                            product = it,
                            isLoading = false
                        )
                    }
                }
            }
        }
    }
}
