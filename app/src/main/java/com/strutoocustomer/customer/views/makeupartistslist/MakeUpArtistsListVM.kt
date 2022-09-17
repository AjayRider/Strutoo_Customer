package com.strutoocustomer.customer.views.makeupartistslist

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
class MakeUpArtistsListVM @Inject constructor():ViewModel(){

    val artistAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_expert) }

    val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
            R.id.layoutArtist -> {
                val bundle = Bundle()
                bundle.putString("comes","ar")
                view.navigateWithId(R.id.makeUpArtistsListToProfileView,bundle)
            }
        }
    }

    init {
        artistAdapter.setOnItemClick(adapterClick)
        artistAdapter.addItems(listOf(
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel()
        ))
    }

    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
        }
    }
}