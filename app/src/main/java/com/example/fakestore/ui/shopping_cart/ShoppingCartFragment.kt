package com.example.fakestore.ui.shopping_cart

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.fakestore.databinding.ShoppingCartBinding

class ShoppingCartFragment : Fragment() {

    private var _binding: ShoppingCartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ShoppingCartBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}