package com.strutoocustomer.customer.views.shop.shopproducts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.FragmentShopProductsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ShopProducts : Fragment() {
    private val viewModel: ShopProductsVM by viewModels()
    private val binding: FragmentShopProductsBinding by lazy {
        FragmentShopProductsBinding.inflate(layoutInflater).apply {
            vm = viewModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding.apply {
            filterList.setOnClickListener {
                rvAllProducts.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                viewModel.allProductsAdapter.notifyDataSetChanged()
                viewModel.isLinear.set(true)
            }
            filterGrid.setOnClickListener {
                rvAllProducts.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                viewModel.allProductsAdapter.notifyDataSetChanged()
                viewModel.isLinear.set(false)
            }
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}