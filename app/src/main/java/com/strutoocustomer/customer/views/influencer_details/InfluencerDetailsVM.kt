package com.strutoocustomer.customer.views.influencer_details

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class InfluencerDetailsVM @Inject constructor() : ViewModel() {

    val influencerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_influencer) }
    val bannerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_banner_artits) }

    val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {
            R.id.layoutInFluencer -> {
                val bundle = Bundle()
                bundle.putString("comes","in")
                view.navigateWithId(R.id.influencerProfile,bundle)
            }
        }
    }

    init {

        bannerAdapter.setOnItemClick(adapterClick)
        bannerAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel()
            )
        )


        influencerAdapter.setOnItemClick(adapterClick)
        influencerAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel()
            )
        )
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
        }
    }
}