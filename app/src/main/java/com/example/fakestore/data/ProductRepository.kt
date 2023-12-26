package com.example.fakestore.data

import com.example.fakestore.data.model.ProductModel
import com.example.fakestore.data.network.ProductService

class ProductRepository {
    private val api = ProductService()

    suspend fun getAllProducts():List<ProductModel>{
        val response = api.getProducts()
        return response
    }
}