package com.strutoocustomer.customer.views.profileview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.utils.fullScreen
import com.strutoocustomer.customer.utils.removeFullScreen
import com.strutoocustomer.databinding.ProfileViewBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ProfileView : Fragment() {
    private val viewModel: ProfileViewVM by viewModels()
    private val binding: ProfileViewBinding by lazy {
        ProfileViewBinding.inflate(layoutInflater).apply {
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments!=null){
            if (requireArguments().containsKey("comes")&&requireArguments().getString("comes" ) == "in") {
                binding.clDetails.background = resources.getDrawable(R.drawable.influencer_gradiant)
                viewModel.isInfluencer.set(true)
            } else {
                binding.clDetails.background = resources.getDrawable(R.drawable.gradient_profile)
                viewModel.isInfluencer.set(false)
            }
        }

        requireActivity().fullScreen()
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        requireActivity().removeFullScreen()
    }
}