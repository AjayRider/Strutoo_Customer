package com.strutoocustomer.customer.views.addaddress

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.views.cart.CartVM
import com.strutoocustomer.databinding.CartBinding
import com.strutoocustomer.databinding.FragmentAddAddressBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AddAddress : Fragment() {
    private val viewModel: AddAddressVM by viewModels()
    private val binding: FragmentAddAddressBinding by lazy { FragmentAddAddressBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewModel.setUpMap(childFragmentManager)
        viewModel.setupPlaces()
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}