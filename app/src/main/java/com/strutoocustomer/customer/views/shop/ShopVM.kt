package com.strutoocustomer.customer.views.shop

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
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShopVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    val trendsAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_shop_trends_top_looks) }
    val bannerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_banner) }
    val allBrandsAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_shop_brands_all_brand) }
    val topBrandsAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_shop_brand_top_brand) }
    val categoryAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_shop_category) }
    var type = ObservableField("CATEGORIES")

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

    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {
            R.id.clCategory -> showOneItem(position)
            R.id.layoutTopBrand ->  view.navigateWithId(R.id.shopToShopProducts)
        }
    }

    private fun showOneItem(position: Int) {
        categoryAdapter.items.forEachIndexed { index, dummyModel ->
            dummyModel.isSelected = position == index
        }
        categoryAdapter.notifyDataSetChanged()
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.tvAddress -> view.navigateWithId(R.id.shopToSearchAddress)
            R.id.tvsellall -> view.navigateWithId(R.id.shopToAllBrands)
            R.id.ivCart -> view.navigateWithId(R.id.shopToCart)
        }
    }


    init {
        trendsAdapter.setOnItemClick(adapterClick)
        bannerAdapter.setOnItemClick(adapterClick)
        allBrandsAdapter.setOnItemClick(adapterClick)
        topBrandsAdapter.setOnItemClick(adapterClick)
        categoryAdapter.setOnItemClick(adapterClick)
        trendsAdapter.addItems(
            listOf(DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel())
        )
        bannerAdapter.addItems(
            listOf(DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel())
        )
        allBrandsAdapter.addItems(
            listOf(DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel())
        )
        topBrandsAdapter.addItems(
            listOf(DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel())
        )
        categoryAdapter.addItems(
            listOf(DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel())
        )

        categoryAdapter.items.map {
            it.childAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_shop_category_item)
            it.childAdapter?.addItems(listOf(DummyModel(),
                DummyModel(), DummyModel(), DummyModel()
            ))
            setOnChildClick(it.childAdapter!!)
        }
    }

    private fun setOnChildClick(childAdapter: RecyclerAdapter<DummyModel>) {
        val childAdapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
            when(view.id) {
                R.id.childLayoutCategory -> {
                   view.navigateWithId(R.id.shopToShopProducts)
                }
            }

        }
        childAdapter.setOnItemClick(childAdapterClick)
    }
}