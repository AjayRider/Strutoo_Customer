package com.strutoocustomer.customer.views.contactus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.FragmentContactUsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ContactUs : Fragment(R.layout.fragment_contact_us) {
    private lateinit var binding: FragmentContactUsBinding

    private val viewModel:ContactUsVM by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentContactUsBinding.bind(view)
        binding.model = viewModel

        binding.apply {
            clCallNow.setOnClickListener {
                phoneCall()
            }
            clWriteUs.setOnClickListener {
                mailSent()
            }
        }
    }

    private fun mailSent() {
        MainActivity.context.get()?.startActivity(Intent(Intent.ACTION_SEND).apply {
            putExtra(Intent.EXTRA_TEXT, "Checkout this amazing app.")
            putExtra(Intent.EXTRA_SUBJECT, "Strutoo")
            putExtra(Intent.EXTRA_EMAIL, "abc@yopmail.com")
        }.setType("message/rfc822"))
    }

    private fun phoneCall() {
        MainActivity.context.get()
            ?.startActivity(Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$9999999999")))
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}

