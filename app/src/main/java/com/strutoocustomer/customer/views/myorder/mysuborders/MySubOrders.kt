package com.strutoocustomer.customer.views.myorder.mysuborders

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.FragmentMySubOrdersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MySubOrders : Fragment() {
    private val viewModel by viewModels<MySubOrdersVM>()
    private val binding: FragmentMySubOrdersBinding by lazy {
        FragmentMySubOrdersBinding.inflate(LayoutInflater.from(requireContext())).apply {
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

    private fun getArgumentData(){
        if (arguments!= null){
            viewModel.fromPast.set(arguments?.getBoolean("isPast"))
            viewModel.setAdapter()
        }
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }

}