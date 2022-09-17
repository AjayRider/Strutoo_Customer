package com.strutoocustomer.customer.views.offers

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OffersVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
):ViewModel(){

    val offersAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_drawer_offers) }

    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {
            R.id.layoutOffer -> view.findNavController().navigate(R.id.shopProducts)
        }
    }

    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
        }
    }

    init {
        offersAdapter.setOnItemClick(adapterClick)
        offersAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (), DummyModel
        ()
        ))
    }
}