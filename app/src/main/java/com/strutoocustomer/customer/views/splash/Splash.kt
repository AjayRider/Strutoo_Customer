package com.strutoocustomer.customer.views.splash

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.SplashBinding
import com.strutoocustomer.utils.navigateWithId

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class Splash : Fragment(R.layout.splash) {

    var binding: SplashBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = SplashBinding.bind(view)

        val animZoomIn: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_in)
        val animUp: Animation =
            AnimationUtils.loadAnimation(requireContext(), R.anim.splash_slide_from_bottom)
        val animDown: Animation = AnimationUtils.loadAnimation(requireContext(), R.anim.zoom_out)
        binding?.ivLogo?.startAnimation(animZoomIn)
        binding?.ivBottom?.startAnimation(animUp)
        CoroutineScope(Dispatchers.Main).launch {
            delay(1400)
            binding?.ivLogo?.startAnimation(animDown)
        }
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
        MainActivity.navListener?.isLockDrawer(true)
        Handler(Looper.getMainLooper()).postDelayed({
            binding?.root?.navigateWithId(R.id.action_splash_to_shop)
        }, 4000)
    }


}