package com.strutoocustomer.customer.views.offers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.OffersBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Offers : Fragment() {

    private val viewModel:OffersVM by viewModels()
    private val binding:OffersBinding by lazy { OffersBinding.inflate(layoutInflater).apply {
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
        MainActivity.navListener?.bottomNav(false)
    }


}