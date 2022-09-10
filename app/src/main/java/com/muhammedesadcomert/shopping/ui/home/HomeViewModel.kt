package com.muhammedesadcomert.shopping.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.data.repository.ProductRepositoryImpl
import com.muhammedesadcomert.shopping.ui.home.model.CategoriesUiState
import com.muhammedesadcomert.shopping.ui.home.model.Product
import com.muhammedesadcomert.shopping.ui.home.productdetail.model.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productRepository: ProductRepositoryImpl) :
    ViewModel() {
    private var _categoriesUiState: MutableLiveData<CategoriesUiState> =
        MutableLiveData(CategoriesUiState.initial())
    val categoriesUiState: LiveData<CategoriesUiState> get() = _categoriesUiState

    private var _products: MutableLiveData<List<Product>> = MutableLiveData()
    val products: LiveData<List<Product>> get() = _products

    private var _productDetail: MutableLiveData<Data> = MutableLiveData()
    val productDetail: LiveData<Data> get() = _productDetail

    init {
        getCategories()
//        getProducts()
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

//    fun getProducts(categoryId: String = DEFAULT_CATEGORY, sort: String = DEFAULT_SORT) {
//        viewModelScope.launch {
//            when (val resource = productRepository.getProducts(categoryId, sort)) {
//                is Resource.Success -> {
//                    resource.data?.let {
//                        _products.postValue(it.products)
//                    }
//                }
//                is Resource.Failure -> {
//                    Log.e("Failure", resource.errorMessage)
//                }
//                else -> {}
//            }
//        }
//    }

//    fun getSingleProductDetail(productId: String) {
//        viewModelScope.launch {
//            when (val resource = productRepository.getSingleProductDetail(productId)) {
//                is Resource.Success -> {
//                    resource.data?.product?.let {
//                        _productDetail.postValue(it)
//                    }
//                }
//                is Resource.Failure -> {
//                    Log.e("Failure", resource.errorMessage)
//                }
//                else -> {}
//            }
//        }
//    }
}