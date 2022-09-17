package com.strutoocustomer.customer.views.liveshows

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.LiveShowsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LiveShows : Fragment(R.layout.live_shows){
    private lateinit var binding: LiveShowsBinding
    val vm :LiveShowsVM by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LiveShowsBinding.inflate(layoutInflater).apply {
            model = vm
        }
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}