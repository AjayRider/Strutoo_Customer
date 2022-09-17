package com.strutoocustomer.customer.views.influencer_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.InfluencerDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class InfluencerDetails : Fragment() {
    private val viewModel: InfluencerDetailsVM by viewModels()
    private val binding: InfluencerDetailsBinding by lazy {
        InfluencerDetailsBinding.inflate(layoutInflater).apply {
            vm = viewModel
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