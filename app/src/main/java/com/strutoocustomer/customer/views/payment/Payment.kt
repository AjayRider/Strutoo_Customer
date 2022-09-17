package com.strutoocustomer.customer.views.payment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.views.booking.bookingdetails.BookingDetailsVM
import com.strutoocustomer.databinding.FragmentBookingDetailsBinding
import com.strutoocustomer.databinding.FragmentPaymentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Payment : Fragment() {
    val viewModel by viewModels<PaymentVM>()
    val binding: FragmentPaymentBinding by lazy { FragmentPaymentBinding.inflate(
        LayoutInflater.from(requireContext())).apply {
        vm = viewModel
    } }

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