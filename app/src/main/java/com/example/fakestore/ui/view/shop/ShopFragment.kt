package com.example.fakestore.ui.view.shop

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakestore.data.model.ProductModel
import com.example.fakestore.databinding.FragmentShopBinding
import com.example.fakestore.ui.view.shop.adapter.ShopAdapter
import com.example.fakestore.ui.viewModel.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ShopFragment : Fragment() {

    private var _binding: FragmentShopBinding? = null
    private val binding get() = _binding!!

    private val productViewModel: ProductViewModel by viewModels()
    private lateinit var adapterProducts: ShopAdapter
    private var firstTime = true

    private var favoriteList: MutableList<ProductModel> = mutableListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentShopBinding.inflate(layoutInflater, container, false)

        initUI()

        return binding.root
    }

    private fun initUI() {
        initList()
        if (firstTime) {
            CoroutineScope(Dispatchers.IO).launch {
                productViewModel.getProducts()
                firstTime = false
            }
        }
    }

    private fun initList() {
        adapterProducts = ShopAdapter()
        binding.rvProducts.layoutManager = GridLayoutManager(requireContext(), 2)
        binding.rvProducts.adapter = adapterProducts

        binding.rvProducts.setHasFixedSize(true)

        productViewModel.productsModelLiveData.observe(viewLifecycleOwner, Observer {
            Log.i("Saul2", it.toString())
            adapterProducts.updateList(productViewModel.productsModelLiveData.value)
        })
    }

    private fun addFavorite(){

    }
}