package com.strutoocustomer.customer.views.studio

import android.os.Bundle
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.StudioBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Studio : Fragment() {
     private val viewModel:StudioVM by viewModels()
    private val binding:StudioBinding by lazy { StudioBinding.inflate(layoutInflater).apply {
        model = viewModel
    } }
    private val scope = MainScope() // could also use an other scope such as viewModelScope if available
    var job: Job? = null
    var position = 1


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        startUpdates()
        return binding.root
    }

    fun startUpdates() {
        stopUpdates()
            job = scope.launch {
            while(true) {
                when(position){
                    1 ->{
                        clearEffect()
                        setProgrammaticallyView(binding.ivFirst)
                        position = 2
                    }
                    2 ->{
                        clearEffect()
                        setProgrammaticallyView(binding.ivSecond)
                        position =3
                    }
                    3 ->{
                        clearEffect()
                        setProgrammaticallyView(binding.ivThird)
                        position =1
                    }
                }
                delay(1500)
            }
        }
    }

    fun stopUpdates() {
        job?.cancel()
        job = null
    }

    override fun onDestroy() {
        super.onDestroy()
        stopUpdates()
    }



    private fun clearEffect(){
        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = ( requireActivity().resources?.displayMetrics?.heightPixels?.times(0.70))?.toInt()
        val width = (requireActivity().resources?.displayMetrics?.widthPixels?.times(0.33))?.toInt()

        binding.ivFirst.layoutParams.width = width?:0
        binding.ivFirst.requestLayout()
        binding.ivSecond.layoutParams.width = width?:0
        binding.ivSecond.requestLayout()
        binding.ivThird.layoutParams.width = width?:0
        binding.ivThird.requestLayout()
    }

    private fun setProgrammaticallyView(view: View){
        val slideAnimate = AnimationUtils.loadAnimation(requireContext(), R.anim.image_slide)
        view.startAnimation(slideAnimate)
        val displayMetrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(displayMetrics)
        val height = ( requireActivity().resources?.displayMetrics?.heightPixels?.times(0.70))?.toInt()
        val width = (requireActivity().resources?.displayMetrics?.widthPixels?.times(0.50))?.toInt()
        view.layoutParams.width = width?:0
        view.requestLayout()
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(true)
    }

}