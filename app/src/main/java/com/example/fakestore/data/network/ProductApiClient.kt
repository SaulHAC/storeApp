package com.example.fakestore.data.network

import com.example.fakestore.data.model.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiClient {
    @GET("products")
    suspend fun getAllProducts():Response<List<ProductModel>>
}