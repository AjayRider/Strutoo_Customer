package com.strutoocustomer.customer.views.promocode

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.PromoCodeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PromoCode : Fragment() {

    private val viewModel: PromoCodeVM by viewModels()
    private val binding: PromoCodeBinding by lazy {
        PromoCodeBinding.inflate(layoutInflater).apply {
            model = viewModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}