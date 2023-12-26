package com.example.fakestore.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakestore.data.ProductRepository
import com.example.fakestore.data.model.ProductModel
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {

    val productsModelLiveData = MutableLiveData<List<ProductModel>>()

    private val repository = ProductRepository()

    suspend fun getProducts(){
        viewModelScope.launch {
            val products = repository.getAllProducts()
            productsModelLiveData.postValue(products)
        }
    }
}