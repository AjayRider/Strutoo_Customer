package com.strutoocustomer.customer.views.product

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.strutoocustomer.MainActivity
import com.strutoocustomer.customer.fragmentadapter.ServicesFragmentAdapter
import com.strutoocustomer.databinding.ProductBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Product :Fragment() {
    private val viewModel: ProductViewModel by viewModels()
    private val binding: ProductBinding by lazy {
        ProductBinding.inflate(layoutInflater).apply {
            vm = viewModel
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val tabLayout = binding.tabLayout
        val viewPager = binding.vpFragment
        viewPager.isSaveEnabled = false
        val fragmentManager: FragmentManager = childFragmentManager
        val fragmentAdapter = ServicesFragmentAdapter(fragmentManager, lifecycle)
        viewPager.adapter = fragmentAdapter
//        viewPager.isUserInputEnabled = false

        TabLayoutMediator(tabLayout, viewPager) { tab, pos ->

            for (i in 0 until tabLayout.tabCount) {
                val tabs = (tabLayout.getChildAt(0) as ViewGroup).getChildAt(i)
                val p = tabs.layoutParams as MarginLayoutParams
                p.setMargins(0, 0, 10, 0)
                tabs.requestLayout()
            }

            when (pos) {
                0 -> tab.text = "Services"
                1 -> tab.text = "Work"
                2 -> tab.text = "REVIEWS"
                else -> tab.text = "About"
            }
        }.attach()

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }


}