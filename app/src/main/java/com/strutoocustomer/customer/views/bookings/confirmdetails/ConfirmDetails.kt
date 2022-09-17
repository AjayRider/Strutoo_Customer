package com.strutoocustomer.customer.views.bookings.confirmdetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.FragmentConfirmDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConfirmDetails : Fragment(R.layout.fragment_confirm_details) {
    val viewModel by viewModels<ConfirmDetailsVM>()
    val binding:FragmentConfirmDetailsBinding by lazy { FragmentConfirmDetailsBinding.inflate(
        LayoutInflater.from(context)).apply {
            vm = viewModel
    }}

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}