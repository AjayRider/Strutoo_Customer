package com.strutoocustomer.customer.views.countrynlanguage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.FragmentCountryNLanguageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CountryNLanguage : Fragment() {
    val viewModel by viewModels<CountryNLangVM>()
    val binding by lazy { FragmentCountryNLanguageBinding.inflate(LayoutInflater.from(requireContext())).
    apply {
        vm = viewModel
    }}

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