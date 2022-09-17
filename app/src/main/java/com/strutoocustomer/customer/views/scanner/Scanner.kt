package com.strutoocustomer.customer.views.scanner

import android.Manifest
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.budiyev.android.codescanner.CodeScanner
import com.budiyev.android.codescanner.DecodeCallback
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import com.strutoocustomer.MainActivity
import com.strutoocustomer.databinding.ScannerBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Scanner : Fragment() {

    private val viewModel:ScannerVM by viewModels()
    private val binding:ScannerBinding by lazy { ScannerBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }

    private var codeScanner: CodeScanner ?= null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        init()
        return binding.root
    }



    fun init(){
        codeScanner = CodeScanner(requireActivity(), binding.scannerView)
        codeScanner?.decodeCallback = DecodeCallback {

        }
        codeScanner?.startPreview()
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
    }

    override fun onPause() {
        if (codeScanner!=null){
            codeScanner?.releaseResources()
        }

        super.onPause()
    }

}