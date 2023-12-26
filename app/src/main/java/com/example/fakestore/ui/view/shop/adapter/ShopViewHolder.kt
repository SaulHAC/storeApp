package com.example.fakestore.ui.view.shop.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fakestore.data.model.ProductModel
import com.example.fakestore.databinding.ItemProductBinding

class ShopViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private val binding = ItemProductBinding.bind(view)

    fun render(item: ProductModel) {
        val context = binding.tvProductName
        binding.tvProductName.text = item.title
        binding.tvPrice.text = "Price: $" + item.price.toString()
        Glide.with(context).load(item.image).into(binding.ivProduct)
    }
}