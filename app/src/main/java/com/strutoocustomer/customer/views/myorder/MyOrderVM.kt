package com.strutoocustomer.customer.views.myorder

import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.android.material.tabs.TabLayout
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
class MyOrderVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
):ViewModel() {

    val myOrderAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_my_order) }
    var isPast = ObservableField(false)

    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {
            R.id.layoutOrder -> view.navigateWithId(R.id.myOrdersToMySubOrders, Bundle().apply {
                putBoolean("isPast",isPast.get()!!)
            })
        }
    }

    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
            R.id.ivFilter -> view.navigateWithId(R.id.myOrdersToOrderFilter)
        }
    }

    var tabListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when (tab?.position) {
                0 -> {
                    isPast.set(false)
                    myOrderAdapter.addItems(listOf(DummyModel(),
                        DummyModel(), DummyModel
                            (), DummyModel
                            ()
                    ))
                }
                1 -> {
                    isPast.set(true)
                    myOrderAdapter.addItems(listOf(DummyModel(isPast = true),
                        DummyModel(isPast = true ), DummyModel
                            (isPast = true ), DummyModel
                            (isPast = true )
                    ))
                }
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    }

    init {
        myOrderAdapter.setOnItemClick(adapterClick)
        myOrderAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (), DummyModel
        ()
        ))
    }

}