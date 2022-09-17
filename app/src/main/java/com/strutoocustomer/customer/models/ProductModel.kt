package com.strutoocustomer.customer.models

import android.os.Parcelable
import com.strutoocustomer.customer.recycleradapter.AbstractModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter

data class ProductModel(
    var _id: String? = "",
    var image: String? = "",
    var productName: String? = "",
    var brandName: String? = "",
    var categoryName: String? = "",
    var subCategoryName: String? = "",
    var prodyctType: String? = "",
    val itemsLeft: String? = "",
    var price: Float? = 0f,
    var ratings: Float? = 0f,
    val specifications: ArrayList<Specifications> = arrayListOf(),
    val moreImages: ArrayList<String> = arrayListOf(),
    var moreDetails: ArrayList<OtherDetails> = arrayListOf(),
    var isSelected: Boolean? = false,
    var offer: String?= "",

    var fromShopScreen:Boolean? = false
) : AbstractModel()

data class Specifications(
    // type 0 = colors, 1 for quantity
    var type: Int? = 0,
    var variants: ArrayList<Variant>,
///    var adapter: RecyclerAdapterViewType? = null

) : AbstractModel()

data class Variant(
    var _id: String = "",
    var variantName: String? = "",

    var isSelected: Boolean? = false
) : AbstractModel()

data class OtherDetails(
    var title: String = "",
//    var detailsList: ArrayList<StringToAbstract> = arrayListOf(),
    var adapter: RecyclerAdapter<*>? = null
): AbstractModel()

/*@Parcelize
data class StringToAbstract(
    val dataInfo: String
):AbstractModel(), Parcelable*/

