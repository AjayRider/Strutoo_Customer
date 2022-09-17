package com.strutoocustomer.customer.views.profileviewdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.ProfileViewDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProfileViewDetails : Fragment() {

    private val viewModel: ProfileViewDetailsVM by viewModels()
    private val binding: ProfileViewDetailsBinding by lazy {
        ProfileViewDetailsBinding.inflate(layoutInflater).apply {
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
        binding.apply {
            filterList.setOnClickListener {
                rvAllProducts.layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
                viewModel.allProductsAdapter.notifyDataSetChanged()
                viewModel.isLinear.set(true)

            }
            filterGrid.setOnClickListener {
                rvAllProducts.layoutManager =
                    GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
                viewModel.allProductsAdapter.notifyDataSetChanged()
                viewModel.isLinear.set(false)

            }
        }
    }

    override fun onResume() {
        super.onResume()
        getData()
        MainActivity.navListener?.bottomNav(false)
    }

    private fun getData() {
        if (requireArguments().getString("comes") == "in") {
            binding.tbLayout.visibility = View.INVISIBLE
            binding.tbLayoutInfluencer.visibility = View.VISIBLE

        } else {
            binding.tbLayoutInfluencer.visibility = View.INVISIBLE
            binding.tbLayout.visibility = View.VISIBLE

        }
    }

}