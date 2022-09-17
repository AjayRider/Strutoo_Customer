package com.strutoocustomer.customer.views.liveshows.golive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.ContextThemeWrapper
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.FragmentGoLiveBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GoLive : Fragment() {
    val model by viewModels<GoLiveVM>()

    val binding:FragmentGoLiveBinding by lazy { FragmentGoLiveBinding.inflate(LayoutInflater.from(requireContext())).apply {
        vm = model
    } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }


    override fun onGetLayoutInflater(savedInstanceState: Bundle?): LayoutInflater {
        val inflater = super.onGetLayoutInflater(savedInstanceState)
        val wrapperContext = ContextThemeWrapper(requireContext(), R.style.TransparantTheme)
        return inflater.cloneInContext(wrapperContext)
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }

}