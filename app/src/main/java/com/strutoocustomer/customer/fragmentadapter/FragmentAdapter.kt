package com.strutoocustomer.customer.fragmentadapter
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.strutoocustomer.customer.views.product.media.view.Pictures
import com.strutoocustomer.customer.views.product.media.view.Videos

class FragmentAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> Pictures()
            else -> Videos()
        }
    }
}