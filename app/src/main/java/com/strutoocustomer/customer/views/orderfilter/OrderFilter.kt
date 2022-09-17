package com.strutoocustomer.customer.views.orderfilter

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.R
import com.strutoocustomer.databinding.OrderFilterBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OrderFilter : Fragment() {

    private val viewModel:OrderFilterVM by viewModels()
    private val binding:OrderFilterBinding by lazy { OrderFilterBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

}