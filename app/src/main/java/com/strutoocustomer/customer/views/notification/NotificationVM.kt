package com.strutoocustomer.customer.views.notification

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NotificationVM @Inject constructor():ViewModel() {

    val recentAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_recent_notification) }
    val oldAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_old_notification) }

    private val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){

        }

    }


    init {

        recentAdapter.setOnItemClick(adapterClick)
        oldAdapter.setOnItemClick(adapterClick)


        recentAdapter.addItems(listOf(DummyModel(), DummyModel()))
        oldAdapter.addItems(listOf(DummyModel(),DummyModel()))
    }




    fun onClick(view:View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
        }
    }


}