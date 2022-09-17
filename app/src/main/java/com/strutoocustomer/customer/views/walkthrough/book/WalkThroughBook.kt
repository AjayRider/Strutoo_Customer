package com.strutoocustomer.customer.views.walkthrough.book

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.utils.fullScreen
import com.strutoocustomer.databinding.WalkThroughBookBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WalkThroughBook : Fragment() {
    private val binding : WalkThroughBookBinding by lazy { WalkThroughBookBinding.inflate(layoutInflater)}
    private val viewModel : WalkThroughBookVM by viewModels()
    private var exoplayer: ExoPlayer ?= null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding.model = viewModel

        return binding.root
    }


   private fun initialize(){
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