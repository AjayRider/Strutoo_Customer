package com.strutoocustomer.customer.views.booking.bookingdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.FragmentBookingDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BookingDetails : Fragment() {
    val viewModel by viewModels<BookingDetailsVM>()
    val binding: FragmentBookingDetailsBinding by lazy {
        FragmentBookingDetailsBinding.inflate(
            LayoutInflater.from(requireContext())
        ).apply {
            vm = viewModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getArgumentData()
        return binding.root
    }

    private fun getArgumentData() {
        if (arguments != null) {
            viewModel.isPast.set(arguments?.getBoolean("isPast"))
        }
    }
    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }

}