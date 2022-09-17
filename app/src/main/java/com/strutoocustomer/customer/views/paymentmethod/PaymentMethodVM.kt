package com.strutoocustomer.customer.views.paymentmethod

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentMethodVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
):ViewModel() {


    val paymentAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_payment_method) }

    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {

        }
    }

    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
            R.id.btnAddNew -> view.navigateWithId(R.id.paymentMethodToAddCard)
        }
    }

    init {
        paymentAdapter.setOnItemClick(adapterClick)
        paymentAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (), DummyModel
        ()
        ))
    }

}