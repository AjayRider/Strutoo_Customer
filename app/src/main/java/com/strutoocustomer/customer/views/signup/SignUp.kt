package com.strutoocustomer.customer.views.signup

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.utils.removeFullScreen
import com.strutoocustomer.databinding.SignUpBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignUp : Fragment() {

    private val viewModel : SignUpVM by viewModels()
    private val binding :SignUpBinding by lazy { SignUpBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().removeFullScreen()
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
        MainActivity.navListener?.isLockDrawer(true)
    }
}