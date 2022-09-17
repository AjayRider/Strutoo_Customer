package com.strutoocustomer.customer.views.booking

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
class BookingVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
):ViewModel() {

    var isPast = ObservableField(false)

    val bookingAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_my_booking) }
    val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
            R.id.layoutBooking -> view.navigateWithId(R.id.bookingToBookingDetails, Bundle().apply {
                putBoolean("isPast",isPast.get()!!)
            })

        }
    }

    var tabListener = object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab?) {
            when (tab?.position) {
                0 -> {
                    isPast.set(false)
                    bookingAdapter.addItems(listOf(DummyModel(),
                        DummyModel(), DummyModel
                            (), DummyModel
                            ()
                    ))
                }
                1 -> {
                    isPast.set(true)
                    bookingAdapter.addItems(listOf(DummyModel(isPast = true),
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
        bookingAdapter.setOnItemClick(adapterClick)
        bookingAdapter.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (), DummyModel
        ()
        ))
    }


    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
            R.id.ivFilter -> view.navigateWithId(R.id.bookingToOrderFilter)
        }
    }
}