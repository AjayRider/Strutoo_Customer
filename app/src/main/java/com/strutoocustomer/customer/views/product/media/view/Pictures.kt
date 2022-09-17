package com.strutoocustomer.customer.views.product.media.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.databinding.PicturesLayoutBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Pictures :Fragment() {
    private val viewModel: PicturesViewModel by viewModels()
    private val binding: PicturesLayoutBinding by lazy { PicturesLayoutBinding.inflate(layoutInflater).apply {
        pictureVM = viewModel
    } }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return binding.root
    }

}