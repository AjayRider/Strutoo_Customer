package com.strutoocustomer.customer.views.paymentmethod

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.PaymentMethodBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PaymentMethod : Fragment() {

    private val viewModel:PaymentMethodVM by viewModels()
    private val binding:PaymentMethodBinding by lazy { PaymentMethodBinding.inflate(layoutInflater).apply {
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