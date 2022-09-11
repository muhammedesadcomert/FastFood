package com.muhammedesadcomert.fastfood.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedesadcomert.fastfood.domain.repository.ProductRepository
import com.muhammedesadcomert.fastfood.ui.detail.model.ProductUiState
import com.muhammedesadcomert.fastfood.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {

    private var _productUiState: MutableLiveData<ProductUiState> =
        MutableLiveData(ProductUiState.initial())
    val productUiState: LiveData<ProductUiState> get() = _productUiState

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
