package com.strutoocustomer.customer.views.checkout

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CheckOutVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
):ViewModel() {

    val cardAdapter by  lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_checkout_card) }

    var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->

        when(view.id){

        }
    }

    init {
        cardAdapter.setOnItemClick(adapterClick)
        cardAdapter.addItems(listOf(DummyModel(),))
        cardAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        ()
        ))
    }


     fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
            R.id.ivAdd -> view.navigateWithId(R.id.checkOutToAddCard)
            R.id.tvAdd -> view.navigateWithId(R.id.checkOutToAddAddress)
            R.id.layoutPay -> view.navigateWithId(R.id.checkOutToOrderPlaced)
        }
    }
}