package com.strutoocustomer.customer.views.servicedetailsstore

import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ServiceVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
):ViewModel() {

    val bannerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_store_banner) }
    val storeAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_store_shop) }
    val productAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_store_product) }
    val similarAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_store_similar_product) }
    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {
            R.id.ivBanner -> view.navigateWithId(R.id.serviceDetailStoreToShop)
            R.id.clService -> view.navigateWithId(R.id.serviceDetailStoreToShop)
        }
    }

    init {
        bannerAdapter.setOnItemClick(adapterClick)
        storeAdapter.setOnItemClick(adapterClick)
        productAdapter.setOnItemClick(adapterClick)
        similarAdapter.setOnItemClick(adapterClick)
        bannerAdapter.addItems(listOf(DummyModel(),DummyModel()))
        storeAdapter.addItems(listOf(DummyModel(),DummyModel(),DummyModel(),DummyModel(),DummyModel(),DummyModel()))
        productAdapter.addItems(listOf(DummyModel(),DummyModel()))
        similarAdapter.addItems(listOf(DummyModel(drawable = ContextCompat.getDrawable(MainActivity.context.get()!!,R.drawable.image_333)), DummyModel(
            drawable = ContextCompat.getDrawable(MainActivity.context.get()!!,R.drawable.mask_group_7))))
    }


    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
            R.id.ivCart -> view.navigateWithId(R.id.serviceDetailStoreToCart)
            R.id.ivHeart -> view.navigateWithId(R.id.wishList)
        }
    }



}