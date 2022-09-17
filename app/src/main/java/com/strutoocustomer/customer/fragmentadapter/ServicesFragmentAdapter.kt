package com.strutoocustomer.customer.fragmentadapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.strutoocustomer.customer.views.product.about.About
import com.strutoocustomer.customer.views.product.media.Media
import com.strutoocustomer.customer.views.product.review.Reviews
import com.strutoocustomer.customer.views.product.services.Services

class ServicesFragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Services()
            1 -> Media()
            2 -> Reviews()
            else -> About()
        }
    }
}