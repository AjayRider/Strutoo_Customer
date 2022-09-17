package com.strutoocustomer.customer.views.product.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.databinding.ServicesBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Services :Fragment() {

    private val viewModel: ServicesViewModel by viewModels()
    private val binding: ServicesBinding by lazy {
        ServicesBinding.inflate(layoutInflater).apply {
            servicesVM = viewModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding.ivRight.setOnClickListener {
            binding.rvServices.post(Runnable {
                binding.rvServices.smoothScrollToPosition(
                    binding
                        .rvServices.adapter?.itemCount?.minus(1) ?: 0
                )
            })
        }
        binding.ivLeft.setOnClickListener {
            binding.rvServices.post(Runnable {
                binding.rvServices.smoothScrollToPosition(
                     0
                )
            })
        }
        return binding.root
    }

}