package com.strutoocustomer.customer.views.rateproduct

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.RateProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RateProduct : Fragment(){

    private lateinit var binding: RateProductBinding
    private val viewModel:RateProductVM by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = RateProductBinding.inflate(layoutInflater).apply {
            model = viewModel
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }

}