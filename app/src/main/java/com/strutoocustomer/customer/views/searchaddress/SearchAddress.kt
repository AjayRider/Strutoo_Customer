package com.strutoocustomer.customer.views.searchaddress

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.customer.utils.statusBarColor
import com.strutoocustomer.databinding.SearchAddressBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchAddress : Fragment() {

    private val viewModel:SearchAddressVM by viewModels()
    private val binding:SearchAddressBinding by lazy { SearchAddressBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().statusBarColor(Color.WHITE)
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().statusBarColor(Color.BLACK)
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}