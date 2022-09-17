package com.strutoocustomer.customer.views.shopproductdetails

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
class ShopProductDetailsVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    val bannerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_banner) }
    val adapterShades by lazy { RecyclerAdapter<DummyModel>(R.layout.item_shades) }
    val adapterSizes by lazy { RecyclerAdapter<DummyModel>(R.layout.item_sizes) }
    val adapterBenefits by lazy { RecyclerAdapter<DummyModel>(R.layout.item_product_about_main) }
    val similarAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_similar_product) }
    val discoverAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_similar_product) }

    var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {
            R.id.layoutType ->showSelected(position)
            R.id.tvAddReview ->view.navigateWithId(R.id.shopProductDetailsToRateProduct)
        }
    }

    private fun showSelected(position: Int) {
        when(adapterBenefits.items[position].text){
            "Benefits"-> adapterBenefits.items[position].type = "Benefits"
            "How to use"->adapterBenefits.items[position].type = "Benefits"
            "Product info"->adapterBenefits.items[position].type = "product"
            "About the brand"->{
                adapterBenefits.items[position].desc = "SUGAR says that it can be used wet or dry, I used it with a wet puff provided in it and Oh My God it did not apply well. It looked patchy even on my oily skin. Applying it wet is not an good idea according to me. Hence, I apply it dry with my foundation buffing brush to set my foundation. The coverage it provides is sheer. It does not conceal any dark spots or pigmentation thoroughly. But does conceal minor spots and gives an even complexion. I enjoy using it over my foundation.\n" +
                        "\n" + "I am obsessed with it. You can see my obsession in my pictures, I have already hit the pan on this product."
                adapterBenefits.items[position].type = "about"
            }
            "Rate & Reviews"->adapterBenefits.items[position].type = "rate"
            "Seller info"->adapterBenefits.items[position].type = "seller"
        }
        adapterBenefits.notifyDataSetChanged()
    }

    init {
        bannerAdapter.setOnItemClick(adapterClick)
        adapterShades.setOnItemClick(adapterClick)
        adapterSizes.setOnItemClick(adapterClick)
        adapterBenefits.setOnItemClick(adapterClick)
        similarAdapter.setOnItemClick(adapterClick)
        discoverAdapter.setOnItemClick(adapterClick)

        bannerAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
            )
        )

        adapterShades.addItems(
            listOf(
                DummyModel(text = "Truffle"),
                DummyModel(text = "Truffle"),
                DummyModel(text = "Truffle"),
                DummyModel(text = "Truffle"),
            )
        )

        adapterSizes.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
            )
        )
        adapterBenefits.addItems(
            listOf(
                DummyModel(text = "Benefits",drawable = ContextCompat.getDrawable(MainActivity.context.get()!!,R.drawable.ic_benifits)),
                DummyModel(text = "How to use",drawable = ContextCompat.getDrawable(MainActivity.context.get()!!,R.drawable.ic_icon_product_1)),
                DummyModel(text = "Product info",drawable =    ContextCompat.getDrawable(MainActivity.context.get()!!,R.drawable.ic_icon_product_2)),
                DummyModel(text = "About the brand",drawable = ContextCompat.getDrawable(MainActivity.context.get()!!,R.drawable.ic_icon_product_3)),
                DummyModel(text = "Rate & Reviews",drawable =  ContextCompat.getDrawable(MainActivity.context.get()!!,R.drawable.ic_icon_product_4)),
                DummyModel(text = "Seller info",drawable =     ContextCompat.getDrawable(MainActivity.context.get()!!,R.drawable.ic_icon_product_5))
            )
        )

        adapterBenefits.items.map {
            it.childAdapter = RecyclerAdapter<DummyModel>(R.layout.item_inner_product_details)
            it.childAdapter?.addItems(listOf(DummyModel(),
                DummyModel(),DummyModel()))
            it.childAdapter?.notifyDataSetChanged()


            it.childSecondAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_shop_product_review)
            it.childSecondAdapter?.addItems(listOf(DummyModel(),
                DummyModel(), DummyModel()))
            it.childSecondAdapter?.notifyDataSetChanged()
        }

        similarAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
            )
        )

        discoverAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
            )
        )
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
            R.id.ivCart -> view.navigateWithId(R.id.shopProductDetailsToCart)
            R.id.ivTry -> view.navigateWithId(R.id.shopProductDetailsToTryOn)
            R.id.layoutPay -> view.navigateWithId(R.id.shopProductDetailsToCart)
        }
    }
}