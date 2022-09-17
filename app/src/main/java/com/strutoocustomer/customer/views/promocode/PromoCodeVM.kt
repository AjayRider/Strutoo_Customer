package com.strutoocustomer.customer.views.promocode

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PromoCodeVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    val promoAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_coupon) }

    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {
            R.id.clPromo -> view.navigateBack()
            R.id.tvActive -> view.navigateBack()
        }
    }

    init {
        promoAdapter.setOnItemClick(adapterClick)
        promoAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel(), DummyModel()
        ))
    }



    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
        }
    }


}