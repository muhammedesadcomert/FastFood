package com.muhammedesadcomert.shopping.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedesadcomert.shopping.common.util.Constant.DEFAULT_CATEGORY
import com.muhammedesadcomert.shopping.common.util.Constant.DEFAULT_SORT
import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.data.repository.ProductRepository
import com.muhammedesadcomert.shopping.ui.home.model.Category
import com.muhammedesadcomert.shopping.ui.home.model.Product
import com.muhammedesadcomert.shopping.ui.home.productdetail.model.Data
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    private var _categories: MutableLiveData<List<Category>> = MutableLiveData()
    val categories: LiveData<List<Category>> get() = _categories

    private var _products: MutableLiveData<List<Product>> = MutableLiveData()
    val products: LiveData<List<Product>> get() = _products

    private var _productDetail: MutableLiveData<Data> = MutableLiveData()
    val productDetail: LiveData<Data> get() = _productDetail

    init {
        getCategories()
        getProducts()
    }

    private fun getCategories() {
        viewModelScope.launch {
            when (val resource = productRepository.getCategories()) {
                is Resource.Success -> {
                    resource.data?.let {
                        _categories.postValue(it.categories)
                    }
                }
                is Resource.Failure -> {
                    Log.e("Failure", resource.errorMessage)
                }
                else -> {}
            }
        }
    }

    fun getProducts(categoryId: String = DEFAULT_CATEGORY, sort: String = DEFAULT_SORT) {
        viewModelScope.launch {
            when (val resource = productRepository.getProducts(categoryId, sort)) {
                is Resource.Success -> {
                    resource.data?.let {
                        _products.postValue(it.products)
                    }
                }
                is Resource.Failure -> {
                    Log.e("Failure", resource.errorMessage)
                }
                else -> {}
            }
        }
    }

    fun getSingleProductDetail(productId: String) {
        viewModelScope.launch {
            when (val resource = productRepository.getSingleProductDetail(productId)) {
                is Resource.Success -> {
                    resource.data?.product?.let {
                        _productDetail.postValue(it)
                    }
                }
                is Resource.Failure -> {
                    Log.e("Failure", resource.errorMessage)
                }
                else -> {}
            }
        }
    }
}