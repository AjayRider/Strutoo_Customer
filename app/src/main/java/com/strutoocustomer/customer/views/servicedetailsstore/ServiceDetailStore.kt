package com.strutoocustomer.customer.views.servicedetailsstore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.ServiceDetailStoreBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ServiceDetailStore : Fragment() {

    private val viewModel: ServiceVM by viewModels()
    private val binding: ServiceDetailStoreBinding by lazy {
        ServiceDetailStoreBinding.inflate(layoutInflater).apply {
            model = viewModel
        }
    }

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