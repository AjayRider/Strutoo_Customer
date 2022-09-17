package com.strutoocustomer.customer.views.product.media.view

import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.models.VideosModel
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.pref.PreferenceFile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PicturesViewModel @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) :ViewModel() {
    val imageAdapter = RecyclerAdapter<VideosModel>(R.layout.videos_view)

    init {
        MainActivity.context.get()?.let {
            val temp = arrayListOf<VideosModel>()
            ContextCompat.getDrawable(it, R.drawable.image_333)
                ?.let { it1 -> VideosModel(videos = it1) }?.let { banner ->
                    temp.add(banner)
                    temp.add(banner)
                    temp.add(banner)
                    temp.add(banner)
                    temp.add(banner)
                    temp.add(banner)
                    temp.add(banner)
                    temp.add(banner)
                    temp.add(banner)
                }
            imageAdapter.addItems(temp)
        }
    }

    fun onClick(view: View) {
        when (view.id) {
        }
    }

}
