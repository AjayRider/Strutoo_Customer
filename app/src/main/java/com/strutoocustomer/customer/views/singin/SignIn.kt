package com.strutoocustomer.customer.views.singin

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.SignInBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class SignIn : Fragment() {

    private val binding:SignInBinding by lazy { SignInBinding.inflate(layoutInflater).apply {
        model =viewModel
    } }
    private val viewModel:SignInVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
        MainActivity.navListener?.isLockDrawer(true)
    }
}