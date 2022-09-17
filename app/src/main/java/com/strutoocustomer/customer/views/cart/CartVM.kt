package com.strutoocustomer.customer.views.cart

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
):ViewModel(){

    var isPromoAdd = ObservableField(false)

    val cartAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_cart) }

    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {

        }
    }

    fun onClick(view: View){
        when(view.id){
            R.id.clPromo -> view.navigateWithId(R.id.cartToPromoCode)
            R.id.ivBack -> view.navigateBack()
            R.id.layoutPay -> view.navigateWithId(R.id.cartToCheckOut)
        }
    }

    init {
        cartAdapter.addItems(listOf(
            DummyModel(),
            DummyModel(), DummyModel()
        ))
        cartAdapter.setOnItemClick(adapterClick)
    }

}