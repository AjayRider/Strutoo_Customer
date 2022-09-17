package com.strutoocustomer.customer.views.shop

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.ShopBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Shop : Fragment() {

    private val viewModel:ShopVM by viewModels()
    private val binding:ShopBinding by lazy { ShopBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(true)
    }


}