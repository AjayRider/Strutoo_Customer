package com.strutoocustomer.customer.views.myorder.mysuborders

import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MySubOrdersVM @Inject() constructor() : ViewModel() {
    val orderNumber = ObservableField("776766")
    val subordersAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_suborder) }
    val fromPast = ObservableField(false)

    val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
            R.id.layoutSubOrder -> view.navigateWithId(R.id.mySubOrdersToSubOrderDetails, Bundle().apply {
                putBoolean("isPast",fromPast.get()!!)
            })
            R.id.tvRateNow -> view.navigateWithId(R.id.rateProduct, Bundle().apply {
                putBoolean("isPast",fromPast.get()!!)
            })
        }
    }

    init {
        subordersAdapter.setOnItemClick(adapterClick)
    }

    fun setAdapter(){
        subordersAdapter.addItems(
            listOf(
                DummyModel(isPast = fromPast.get()?:false, isSelected = true),
                DummyModel(isPast = fromPast.get()?:false, isSelected = false),
                DummyModel(isPast = fromPast.get()?:false)
            )
        )
    }
    fun onClick(view: View) {
        when(view.id) {
            R.id.ivBack -> view.navigateBack()
        }
    }
}