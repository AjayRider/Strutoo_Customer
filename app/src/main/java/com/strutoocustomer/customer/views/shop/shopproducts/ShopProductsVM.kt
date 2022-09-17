package com.strutoocustomer.customer.views.shop.shopproducts

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ShopProductsVM @Inject constructor() : ViewModel() {
    val categoriesAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_tab_type_purple) }
    val subCategoryAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_subcategory) }
    val allProductsAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_product_manage) }
    var isLinear = ObservableField(true)
    
    private val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
            R.id.layoutProduct -> view.navigateWithId(R.id.shopProductsToShopProductDetails)
        }
    }

    init {
        categoriesAdapter.setOnItemClick(adapterClick)
        subCategoryAdapter.setOnItemClick(adapterClick)
        allProductsAdapter.setOnItemClick(adapterClick)

        categoriesAdapter.addItems(
            listOf(
                DummyModel(text = "Face", isSelected = true),
                DummyModel(text = "Legs"),
                DummyModel(text = "Lips"),
                DummyModel(text = "Brushes & Tools")
            )
        )
        categoriesAdapter.setOnItemClick() { v, p, t ->
            categoriesAdapter.getAllItems().forEach { it.isSelected = false }
            categoriesAdapter.getAllItems()[p].isSelected = true
            categoriesAdapter.notifyDataSetChanged()
        }

        subCategoryAdapter.addItems(
            listOf(
                DummyModel(text = "Primer", isSelected = true),
                DummyModel(text = "Concealer"),
                DummyModel(text = "Foundation"),
                DummyModel(text = "Blusher")
            )
        )
        subCategoryAdapter.setOnItemClick() { v, p, t ->
            subCategoryAdapter.getAllItems().forEach { it.isSelected = false }
            subCategoryAdapter.getAllItems()[p].isSelected = true
            subCategoryAdapter.notifyDataSetChanged()
        }

        allProductsAdapter.addItems(
            listOf(
                DummyModel(text = "Mac Primer"),
                DummyModel(text = "Mac Primer"),
                DummyModel(text = "Mac Primer"),
                DummyModel(text = "Mac Primer"),
                DummyModel(text = "Mac Primer"),
                DummyModel(text = "Mac Primer"),
            )
        )
    }

    fun onClick(view: View){
        when(view.id){
           R.id.ivBack -> view.navigateBack()
           R.id.ivHeart -> view.navigateWithId(R.id.shopProductsToWishList)
           R.id.ivCart -> view.navigateWithId(R.id.shopProductsToCart)
           R.id.ivSearch -> view.navigateWithId(R.id.shopProductsToSearch)
           R.id.ivFilterProducts -> view.navigateWithId(R.id.shopProductsToFilters)
        }
    }
}