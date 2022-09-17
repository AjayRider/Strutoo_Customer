package com.strutoocustomer.customer.views.book

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {
    val bannerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_banner) }
    val servicesAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_discover_service) }
    val topSalonsAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_salons) }
    val bookCatInnerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_book_cat_inner) }

    var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
            R.id.layoutBookService -> view.navigateWithId(R.id.bookToBookList)
            R.id.cvSalon->{//have to add click
            }
        }
    }

    init {
        servicesAdapter.setOnItemClick(adapterClick)
        topSalonsAdapter.setOnItemClick(adapterClick)
        bannerAdapter.setOnItemClick(adapterClick)
        bookCatInnerAdapter.setOnItemClick(adapterClick)
        servicesAdapter.addItems(listOf(
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),

        ))
        bookCatInnerAdapter.addItems(listOf(
            DummyModel(name = "top salons"),
            DummyModel(name ="top skin clinic"),
            DummyModel(name ="top gyms"),
        ))



        bookCatInnerAdapter.getAllItems().map {
            it.innerBookAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_salons)
            it.innerBookAdapter!!.addItems(listOf(
                DummyModel(), DummyModel(), DummyModel(),
                DummyModel(),
            ))
            it.innerBookAdapter!!.setOnItemClick(adapterClick)
        }

        bannerAdapter.addItems(listOf(
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
        ))

        topSalonsAdapter.addItems(listOf(
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),

            ))
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.ivBook -> view.navigateWithId(R.id.bookToBookings)
        }

    }

}