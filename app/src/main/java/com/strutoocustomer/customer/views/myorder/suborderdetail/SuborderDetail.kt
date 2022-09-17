package com.strutoocustomer.customer.views.myorder.suborderdetail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.FragmentSuborderDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SuborderDetail : Fragment() {
    private val viewModel by viewModels<SuborderDetailVM>()
    private val binding: FragmentSuborderDetailBinding by lazy { FragmentSuborderDetailBinding.inflate(LayoutInflater.from(requireContext())).apply {
        vm = viewModel

    } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        getArgumentData()
        return binding.root
    }

   private fun getArgumentData(){
        if (arguments!= null){
            viewModel.isPast.set(arguments?.getBoolean("isPast"))
        }
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}
