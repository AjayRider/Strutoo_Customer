package com.strutoocustomer.customer.views.filters

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
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
class FiltersVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {
    var filterType = ObservableInt(1) // 1->means by default filter 0-> Sort
    var sortText = ObservableField("Sort")
    var filterText = ObservableField("Filters")
    var titleFilterText = ObservableField("Select Price range")
    var isPriceClick = ObservableBoolean(false)

    /*Filter Names Adapter */
    val adapterNames by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_filter_category) }

    /*Filters Data Adapter*/
    val adapterCommon by lazy { RecyclerAdapter<DummyModel>(R.layout.item_filter_list) }

    /*All Filters List */
    var categoryList = ArrayList<DummyModel>()
    var discountList = ArrayList<DummyModel>()
    var ratingList = ArrayList<DummyModel>()
    var brandList = ArrayList<DummyModel>()
    var typeList = ArrayList<DummyModel>()
    var sizeList = ArrayList<DummyModel>()
    var colorList = ArrayList<DummyModel>()
    var sortList = ArrayList<DummyModel>()


    init {
        isPriceClick.set(true)
        ratingList.addAll(
            listOf(
                DummyModel(name = "1", filterType = 1),
                DummyModel(name = "2", filterType = 1),
                DummyModel(name = "3", filterType = 1),
                DummyModel(name = "4", filterType = 1),
                DummyModel(name = "5", filterType = 1),
            )
        )

        categoryList.addAll(
            listOf(
                DummyModel(name = "Cosmetics", filterType = 2),
                DummyModel(name = "Cosmetics", filterType = 2),
                DummyModel(name = "Cosmetics", filterType = 2),
                DummyModel(name = "Cosmetics", filterType = 2),
                DummyModel(name = "Cosmetics", filterType = 2),
                DummyModel(name = "Cosmetics", filterType = 2),
                DummyModel(name = "Cosmetics", filterType = 2),
                DummyModel(name = "Cosmetics", filterType = 2),
            )
        )

        brandList.addAll(
            listOf(
                DummyModel(name = "Becca", filterType = 3),
                DummyModel(name = "Becca", filterType = 3),
                DummyModel(name = "Becca", filterType = 3),
                DummyModel(name = "Becca", filterType = 3),
                DummyModel(name = "Becca", filterType = 3),
                DummyModel(name = "Becca", filterType = 3),
                DummyModel(name = "Becca", filterType = 3),
                DummyModel(name = "Becca", filterType = 3),
                DummyModel(name = "Becca", filterType = 3)
            )
        )

        discountList.addAll(
            listOf(
                DummyModel(name = "10%", filterType = 4),
                DummyModel(name = "10%", filterType = 4),
                DummyModel(name = "10%", filterType = 4),
                DummyModel(name = "10%", filterType = 4),
                DummyModel(name = "10%", filterType = 4),
                DummyModel(name = "10%", filterType = 4),
                DummyModel(name = "10%", filterType = 4),
                DummyModel(name = "10%", filterType = 4),
                DummyModel(name = "10%", filterType = 4)
            )
        )

        sizeList.addAll(
            listOf(
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5),
                DummyModel(name = "7-ml", filterType = 5)
            )
        )

        colorList.addAll(
            listOf(
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6),
                DummyModel(name = "Pink", filterType = 6)
            )
        )

        typeList.addAll(
            listOf(
                DummyModel(name = "Type", filterType = 7),
                DummyModel(name = "Type", filterType = 7),
                DummyModel(name = "Type", filterType = 7),
                DummyModel(name = "Type", filterType = 7),
                DummyModel(name = "Type", filterType = 7),
                DummyModel(name = "Type", filterType = 7),
                DummyModel(name = "Type", filterType = 7),
                DummyModel(name = "Type", filterType = 7),
                DummyModel(name = "Type", filterType = 7)
            )
        )

//        sortList.addAll(
//            listOf(
//                DummyModel(name = "New Products", filterType = 11),
//                DummyModel(name = "Price - high to low", filterType = 11),
//                DummyModel(name = "Price - low to high", filterType = 11),
//                DummyModel(name = "Popularity", filterType = 11),
//            )
//        )


        when (filterType.get()) {
            1 -> {
                adapterNames.addItems(
                    listOf(
                        DummyModel(name = "Price", isSelected = true),
                        DummyModel(name = "Services"),
                        DummyModel(name = "Ratings"),
                        DummyModel(name = "Discount"),
                        DummyModel(name = "Open/Close"),
                        DummyModel(name = "City"),
                        DummyModel(name = "Area")
                    )
                )

                adapterCommon.addItems(categoryList)
            }
            0 -> {
                adapterNames.addItems(
                    listOf(
                        DummyModel(name = "Sort", isSelected = true)
                    )
                )
                adapterCommon.addItems(sortList)
            }
            else -> {
                adapterNames.addItems(
                    listOf(
                        DummyModel(name = "Price", isSelected = true),
                        DummyModel(name = "Services"),
                        DummyModel(name = "Ratings"),
                        DummyModel(name = "Discount"),
                        DummyModel(name = "Open/Close"),
                        DummyModel(name = "City"),
                        DummyModel(name = "Area")
                    )
                )
            }
        }


        adapterNames.setOnItemClick { view, position, type ->
            if (filterType.get() == 1) {
                adapterNames.getAllItems().map {
                    it.isSelected = false
                }
                adapterNames.getAllItems()[position].isSelected = true
                adapterNames.notifyDataSetChanged()
                when (position) {
                    0 -> {

                        titleFilterText.set("Select Price range")
                        isPriceClick.set(true)
                    }
                    1 -> {
                        titleFilterText.set("Select Category")
                        adapterCommon.addItems(categoryList)
                        isPriceClick.set(false)
                    }
                    2 -> {
                        titleFilterText.set("Select Rating")
                        isPriceClick.set(false)
                        adapterCommon.addItems(ratingList)
                    }
                    3 -> {
                        titleFilterText.set("Select Discount")
                        isPriceClick.set(false)
                        adapterCommon.addItems(discountList)
                    }
                    4 -> {
                        titleFilterText.set("Select Brand")
                        isPriceClick.set(false)
                        adapterCommon.addItems(brandList)
                    }
                    5 -> {
                        titleFilterText.set("Select Type")
                        isPriceClick.set(false)
                        adapterCommon.addItems(typeList)
                    }
                    6 -> {
                        titleFilterText.set("Select Size")
                        isPriceClick.set(false)
                        adapterCommon.addItems(sizeList)
                    }
                    7 -> {
                        titleFilterText.set("Select Color")
                        isPriceClick.set(false)
                        adapterCommon.addItems(colorList)
                    }
                }
            } else {
                isPriceClick.set(false)
                adapterCommon.addItems(sortList)
            }
        }
    }


    fun onClick(view: View) {
        when (view.id) {
            R.id.tvSortOrFilter -> {
                when (filterType.get()) {
                    0 -> {
                        isPriceClick.set(true)
                        sortText.set("Sort")
                        filterText.set("Filters")
                        filterType.set(1)

                        adapterNames.addItems(
                            listOf(
                                DummyModel(name = "Price", isSelected = true),
                                DummyModel(name = "Services"),
                                DummyModel(name = "Ratings"),
                                DummyModel(name = "Discount"),
                                DummyModel(name = "Open/Close"),
                                DummyModel(name = "City"),
                                DummyModel(name = "Area")
                            )
                        )

                    }
                    1 -> {
                        isPriceClick.set(false)
                        sortText.set("Filters")
                        filterText.set("Sort")
                        filterType.set(0)

                        adapterNames.addItems(
                            listOf(
                                DummyModel(
                                    name = "Sort by"
                                )
                            )
                        )
                        adapterCommon.addItems(
                            listOf(
                                DummyModel(name = "Nearest", filterType = 11),
                                DummyModel(name = "Furthest", filterType = 11),
                                DummyModel(name = "Most Popular", filterType = 11),
                                DummyModel(name = "Lowest Price", filterType = 11),
                                DummyModel(name = "Highest Price", filterType = 11),
                                DummyModel(name = "Highest Rated", filterType = 11),
                            )
                        )
                    }
                    else -> {
                        sortText.set("Sort")
                        filterText.set("Filters")
                        filterType.set(1)

                        adapterNames.addItems(
                            listOf(
                                DummyModel(name = "Price", isSelected = true),
                                DummyModel(name = "Services"),
                                DummyModel(name = "Ratings"),
                                DummyModel(name = "Discount"),
                                DummyModel(name = "Open/Close"),
                                DummyModel(name = "City"),
                                DummyModel(name = "Area")
                            )
                        )
                    }
                }
            }
            R.id.ivBackFilter -> {
                view.navigateBack()
            }
            R.id.btApplyFilter -> {
                view.navigateBack()
            }
        }
    }

}