package com.strutoocustomer.customer.views.makeupartist

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.viewpager2.widget.ViewPager2
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MakeUpArtistsVM @Inject constructor() : ViewModel() {
    val makeUpArtistAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_makupartist_singleitems) }
    val bannerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_banner_artits) }

    val view = ObservableField<ViewPager2>()

    private val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {

        }
    }

    init {
        makeUpArtistAdapter.setOnItemClick(adapterClick)
        bannerAdapter.setOnItemClick(adapterClick)
        makeUpArtistAdapter.addItems(
            listOf(
                DummyModel(text = "OUR EXPERTS"),
                DummyModel(text = "Makeup Artist"), DummyModel
                    (text = "Hair stylist"), DummyModel(text = "Esthetian")
            )
        )

        bannerAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel()
            )
        )

        makeUpArtistAdapter.items.map {
            it.childAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_makupartist_singleitems_singleitem)
            it.childAdapter?.addItems(listOf(DummyModel(),
                DummyModel(), DummyModel()
            ))
            setOnChildClick(it.childAdapter!!)
        }
    }

    private fun setOnChildClick(childAdapter: RecyclerAdapter<DummyModel>) {
        val childAdapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
            when(view.id) {
                R.id.layoutArtist -> view.navigateWithId(R.id.makeUpArtistsToMakeUpArtistList)
            }

        }
        childAdapter.setOnItemClick(childAdapterClick)
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
        }
    }
}