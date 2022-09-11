package com.muhammedesadcomert.shopping.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.muhammedesadcomert.shopping.common.util.Resource
import com.muhammedesadcomert.shopping.data.repository.ProductRepository
import com.muhammedesadcomert.shopping.ui.home.model.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val productRepository: ProductRepository) :
    ViewModel() {
    private var _categories: MutableLiveData<List<Category>> = MutableLiveData()
    val categories: LiveData<List<Category>> get() = _categories

    init {
        getCategories()
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

                }
                else -> {}
            }
        }
    }
}