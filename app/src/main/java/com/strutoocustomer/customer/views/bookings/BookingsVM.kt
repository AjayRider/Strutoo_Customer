package com.strutoocustomer.customer.views.bookings

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
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
class BookingsVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {
    val bookingListAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_cart) }
    var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){

        }
    }
//    val note = ObservableField(notelong)

    init {
        bookingListAdapter.setOnItemClick(adapterClick)
        bookingListAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(name = "Hair Color", desc = "SALENA", desc2 = "EGP 49.00 for 1 person")
            )
        )

//        val noteText = SpannableString("Note : If you choose to cancel, you can do it within 60\n" +
//                "seconds after booking service. Post which you will be charged 100% cancellation fee.")
//        noteText.setSpan(
//            ForegroundColorSpan(Color.parseColor("#ec1550")),
//            1,
//            5,
//            Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
//        )
//        note.set(noteText.toString())
    }

    fun onClick(view: View) {
        when(view.id){
            R.id.ivBack -> view.navigateBack()
            R.id.btnConfirmDetails -> view.navigateWithId(R.id.bookingsToConfirmDetails)
        }
    }
}