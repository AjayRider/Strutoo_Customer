package com.strutoocustomer.customer.models

import android.graphics.drawable.Drawable
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.AbstractModel
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter

data class SalonBanner(
    val banner: Drawable,
) : AbstractModel()

data class PublicReviews(
    val userImage: Drawable?,
    val name: String,
    val subject: String,
    val isVerified: Boolean = false,
    val reviewDate: String,
    val review: String,
    val starsCount: Int,
    val helpful: Int = 0,
    val productImage: Drawable?,
    val productImage2: Drawable?,
) : AbstractModel(){
    val reviewAdapter = RecyclerAdapter<DummyModel>(R.layout.item_inner_review)

    init {
        reviewAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (), DummyModel
        (), DummyModel
        (),DummyModel
        ()))
    }
}

data class VideosModel(
    val videos: Drawable
) : AbstractModel()

data class StaffsDetails(
    val staffImage: Drawable?,
    val staffName: String,
) : AbstractModel()

data class ServicesDetails(
    val servicesImage: Drawable?,
    val servicesName: String,
) : AbstractModel()

data class TypesOfHairCuts(
    val hairCutPrice: String,
    val hairCutType: String,
    val hairCutTime: String,
    var isSelected: Boolean = false,

    ) : AbstractModel() {

    var childAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_hair_cut_provider)

    init {



        childAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(),
                DummyModel(), DummyModel(),DummyModel(),
                DummyModel(), DummyModel(),DummyModel(),
                DummyModel(),
            )
        )
    }
}

data class ServicesTypes(
    val servicesTypesName: String,
    var isSelected: Boolean = false,
) : AbstractModel() {
    val hairCutAdapter = RecyclerAdapter<TypesOfHairCuts>(R.layout.women_haircuts)

    init {
        hairCutAdapter.addItems(
            listOf(
                TypesOfHairCuts(
                    "49.00 ",
                    "Hair Cut & Blow Dry",
                    "45 Mins"
                ),
                TypesOfHairCuts(
                    "69.00 ",
                    "Blow Dry",
                    "1 Hours"
                ),
                TypesOfHairCuts(
                    "85.00  ",
                    "Image Consulting",
                    "30 Mins"
                ),
                TypesOfHairCuts(
                    "35.00 ",
                    "EQ Shades Glossing",
                    "30 Mins"
                ),
                TypesOfHairCuts(
                    "70.00 ",
                    "Ladies Shampoo & Set",
                    "30 Mins"
                ),
            )
        )
    }
}


data class OtherBranches(
    val branchType: String,
    val branchAddress: String,
) : AbstractModel()