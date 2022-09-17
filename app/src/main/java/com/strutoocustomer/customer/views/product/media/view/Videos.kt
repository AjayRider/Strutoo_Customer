package com.strutoocustomer.customer.views.product.media.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.databinding.VideosLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Videos :Fragment() {

    private val viewModel: VideosViewModel by viewModels()
    private val binding: VideosLayoutBinding by lazy { VideosLayoutBinding.inflate(layoutInflater).apply {
        vm = viewModel
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }


}