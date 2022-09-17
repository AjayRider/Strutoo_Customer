package com.strutoocustomer.customer.views.profileviewdetails

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.android.material.tabs.TabLayout
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewDetailsVM @Inject constructor():ViewModel() {
    var type = ObservableField("Shop")

    var isLinear = ObservableField(true)



    val allProductsAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_product_manage) }
    val byLookAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_by_look) }
    val learnAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_learn_video) }

    private val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
//            R.id.layoutProduct -> view.navigateWithId(R.id.shopProductsToShopProductDetails)
        }
    }

    init {
        allProductsAdapter.setOnItemClick(adapterClick)
        byLookAdapter.setOnItemClick(adapterClick)
        learnAdapter.setOnItemClick(adapterClick)
        allProductsAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (),DummyModel
        ()))

        byLookAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (),DummyModel
        ()))

        learnAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (),DummyModel
        ()))

        byLookAdapter.items.map {
            it.childAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_banner)
            it.childSecondAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_rv_by_look)
            it.childAdapter?.addItems(listOf(DummyModel(),
                DummyModel(), DummyModel(), DummyModel()
            ))
            it.childSecondAdapter?.addItems(listOf(DummyModel(),
                DummyModel(), DummyModel(), DummyModel()
            ))
            setOnChildClick(it.childAdapter!!)
            setOnSecondChildClick(it.childSecondAdapter!!)
        }

    }

    private fun setOnChildClick(childAdapter: RecyclerAdapter<DummyModel>) {
        val childAdapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
            when(view.id) {

            }

        }
        childAdapter.setOnItemClick(childAdapterClick)
    }
   private fun setOnSecondChildClick(childAdapter: RecyclerAdapter<DummyModel>) {
        val childAdapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
            when(view.id) {

            }

        }
        childAdapter.setOnItemClick(childAdapterClick)
    }

    var tabListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when (tab?.position) {
                0 -> {
                    type.set(tab.text.toString())
                }
                1 -> {
                    type.set(tab.text.toString())
                }
                2 -> {
                    type.set(tab.text.toString())
                }
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    }


    var tabListenerInfluencer = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when (tab?.position) {
                0 -> {
                    type.set(tab.text.toString())
                }
                1 -> {
                    type.set(tab.text.toString())
                }
            }
        }

        override fun onTabUnselected(tab: TabLayout.Tab?) {}
        override fun onTabReselected(tab: TabLayout.Tab?) {}
    }


    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
        }
    }
}