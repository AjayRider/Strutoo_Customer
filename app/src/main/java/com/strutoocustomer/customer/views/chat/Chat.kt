package com.strutoocustomer.customer.views.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.ChatBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Chat : Fragment(R.layout.chat) {
    private val viewModel by viewModels<ChatVM>()
    private val binding: ChatBinding by lazy { ChatBinding.inflate(LayoutInflater.from(requireContext())).apply {
        vm = viewModel
    } }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }
    private val goBack = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            try {

                Navigation.findNavController(requireView()).popBackStack()

            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

    override fun onDetach() {
        super.onDetach()
        goBack.remove()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().onBackPressedDispatcher.addCallback(requireActivity(), goBack)
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }
}