package com.strutoocustomer.customer.views.product.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.databinding.AboutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class About :Fragment() {
    private val viewModel: AboutViewModel by viewModels()
    private val binding: AboutBinding by lazy {
        AboutBinding.inflate(layoutInflater).apply {
            aboutVM = viewModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}