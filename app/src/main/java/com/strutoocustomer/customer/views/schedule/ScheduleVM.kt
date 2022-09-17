package com.strutoocustomer.customer.views.schedule

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleVM @Inject constructor():ViewModel() {

    val recommendAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_seller) }

    private val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
//            R.id.layoutProduct -> view.navigateWithId(R.id.shopProductsToShopProductDetails)
        }
    }
    init {
        recommendAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        ()
        ))
        recommendAdapter.setOnItemClick(adapterClick)
    }

    fun onClick(view: View){

        when(view.id){
            R.id.ivBack -> view.navigateBack()
        }

    }


}