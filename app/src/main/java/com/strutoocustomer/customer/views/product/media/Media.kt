package com.strutoocustomer.customer.views.product.media

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import com.google.android.material.tabs.TabLayoutMediator
import com.strutoocustomer.customer.fragmentadapter.FragmentAdapter
import com.strutoocustomer.databinding.MediaLayoutBinding


class Media :Fragment() {
    private val viewModel: MediaViewModel by viewModels()
    private val binding: MediaLayoutBinding by lazy {
        MediaLayoutBinding.inflate(layoutInflater)
            .apply {
                mediaVM = viewModel
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mediaTabLayout = binding.mediaTabLayout
        val viewPager = binding.vpFragment

        val fragmentManager: FragmentManager = childFragmentManager
        val fragmentAdapter = FragmentAdapter(fragmentManager, lifecycle)
        viewPager.adapter = fragmentAdapter

        TabLayoutMediator(mediaTabLayout, viewPager) { tab, pos ->

            if (pos == 0) {
                tab.text = "Videos"
            } else {
                tab.text = "Pictures"
            }

        }.attach()

        return binding.root
    }

}