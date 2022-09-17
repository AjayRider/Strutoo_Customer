package com.strutoocustomer.customer.views.product.review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.databinding.ReviewsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Reviews :Fragment() {
    private val viewModel: ReviewsViewModel by viewModels()
    private val binding: ReviewsBinding by lazy {
        ReviewsBinding.inflate(layoutInflater).apply {
            reviewVM = viewModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

}