package com.strutoocustomer.customer.views.walkthrough.shop

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.utils.fullScreen
import com.strutoocustomer.databinding.WalkThroughShopBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class WalkThroughShop : Fragment() {
    private val binding: WalkThroughShopBinding by lazy { WalkThroughShopBinding.inflate(layoutInflater) }
    private val viewModel: WalkThroughShopVM by viewModels()

    private  var exoplayer: ExoPlayer ? =null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding.model = viewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().fullScreen()
    }

    fun initialize(){
        exoplayer = ExoPlayer.Builder(requireContext()).build()
        binding.playerView.player = exoplayer
        val path =getUriFromRawFile(requireContext(), R.raw.hair_cut)
        val  mediaItem : MediaItem = MediaItem.fromUri(path)
        exoplayer?.addMediaItem(mediaItem)
        exoplayer?.prepare()
        exoplayer?.repeatMode = Player.REPEAT_MODE_ALL
        exoplayer?.playWhenReady = true
    }

    private fun getUriFromRawFile(context: Context, rawResourceId: Int): Uri {
        return Uri.Builder()
            .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
            .authority(context.packageName)
            .path(rawResourceId.toString())
            .build()
    }

    override fun onResume() {
        super.onResume()
        MainActivity.navListener?.bottomNav(false)
        initialize()
    }

    override fun onPause() {
        super.onPause()
        exoplayer?.release()
    }
}