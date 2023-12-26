package com.example.fakestore.data.model

import com.google.gson.annotations.SerializedName

data class ProductModel(
    @SerializedName("id") val id: String,
    @SerializedName("title") val title: String,
    @SerializedName("price") val price: Float,
    @SerializedName("image") val image: String
)