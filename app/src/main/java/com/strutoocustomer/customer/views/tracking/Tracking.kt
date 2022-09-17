package com.strutoocustomer.customer.views.tracking

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.TrackingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Tracking : Fragment() {

    private val viewModel:TrackingVM by viewModels()
    private val binding:TrackingBinding by lazy { TrackingBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
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