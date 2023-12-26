package com.example.fakestore.data.network

import com.example.fakestore.core.RetrofitHelper
import com.example.fakestore.data.model.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ProductService {
    private val retrofit = RetrofitHelper.getRetrofit()

    suspend fun getProducts():List<ProductModel>{
        return withContext(Dispatchers.IO){
            val response = retrofit.create(ProductApiClient::class.java).getAllProducts()
            response.body() ?: emptyList()
        }
    }
}