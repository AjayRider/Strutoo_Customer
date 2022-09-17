package com.strutoocustomer.customer.views.allbrands

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.AllBrandsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AllBrands : Fragment() {

    private val viewModel:AllBrandsVM by viewModels()
    private val binding:AllBrandsBinding by lazy { AllBrandsBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
//        binding.rvFastScroll.setIndexTextSize = 20
//        binding.rvFastScroll.setIndexBarTextColor("#FFFFFF")
//        binding.rvFastScroll.setIndexBarColor(R.color.transparent)
//        binding.rvFastScroll.setIndexbarMargin(4f)
//        binding.rvFastScroll.setIndexbarWidth(40f)
//        binding.rvFastScroll.setPreviewPadding(5)
//        binding.rvFastScroll.setIndexbarHighLightTextColor("#33334c")
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }


}