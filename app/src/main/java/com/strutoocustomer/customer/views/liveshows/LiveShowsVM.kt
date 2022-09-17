package com.strutoocustomer.customer.views.liveshows

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LiveShowsVM @Inject constructor() : ViewModel() {

    var islive = ObservableBoolean(true)

    var adapterLive = RecyclerAdapter<DummyModel>(R.layout.item_layout_liveshows)
    var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
            R.id.clProfile ->{
                if (islive.get()){
                    view.navigateWithId(R.id.liveShowsToGoLive)
                }else{
                    view.navigateWithId(R.id.liveShowsToSchedule)
                }
            }

        }
    }

    init {

        adapterLive.setOnItemClick(adapterClick)
        adapterLive.addItems(listOf(DummyModel(isPast = true),
            DummyModel(isPast = true), DummyModel
        (isPast = true), DummyModel
                (isPast = true),DummyModel
                (isPast = true)))
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.tvLiveShowsCl -> {
                islive.set(true)
                adapterLive.addItems(listOf(DummyModel(isPast = true),
                    DummyModel(isPast = true), DummyModel
                        (isPast = true), DummyModel
                        (isPast = true),DummyModel
                        (isPast = true)))
            }

            R.id.tvSchedule -> {
                islive.set(false)
                adapterLive.addItems(listOf(DummyModel(isPast = false),
                    DummyModel(isPast = false), DummyModel
                        (isPast = false), DummyModel
                        (isPast = false),DummyModel
                        (isPast = false)))
            }

            R.id.ivBack -> view.navigateBack()

            R.id.ivSearch ->{
                view.navigateWithId(R.id.liveShowsToSearchStudio)
            }
        }
    }
}