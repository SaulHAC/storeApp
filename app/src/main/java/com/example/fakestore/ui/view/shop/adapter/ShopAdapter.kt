package com.example.fakestore.ui.view.shop.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.fakestore.R
import com.example.fakestore.data.model.ProductModel

class ShopAdapter(var productsList: List<ProductModel> = emptyList()): RecyclerView.Adapter<ShopViewHolder>() {

    fun updateList(productsList: List<ProductModel>?){
        this.productsList = productsList ?: emptyList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ShopViewHolder(layoutInflater.inflate(R.layout.item_product, parent, false))
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        val item = productsList[position]
        holder.render(item)
    }

    override fun getItemCount() = productsList.size
}