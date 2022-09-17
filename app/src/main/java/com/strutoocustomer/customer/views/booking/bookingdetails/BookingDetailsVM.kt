package com.strutoocustomer.customer.views.booking.bookingdetails

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
class BookingDetailsVM @Inject constructor(): ViewModel() {
    var title = ObservableField("")
    var time = ObservableField("")
    var image = ObservableField("")
    var serviceType = ObservableField("")
    var pickUpAddress = ObservableField("")
    var dropAddress = ObservableField("")
    var custName = ObservableField("")
    var custPhone = ObservableField("")
    var countryCode = ObservableField("")
    var ratings = ObservableField(0f)
    val serviceStatus = ObservableField(1)
    var isPast = ObservableField(false)

   // service status if isPast == true
//    val isPast = MutableLiveData(false)
    val confirmBookingAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_confirm_detail) }

    init {
        confirmBookingAdapter.addItems(
            listOf(
                DummyModel(
                    text = "Hair Color",
                    desc = "Salena"
                ),
                DummyModel(
                    text = "Makeup",
                    desc = "Salena"
                ),
                DummyModel(
                    text = "Nail Makeover",
                    desc = "Salena"
                )
            )
        )
        title.set("Curls Unisex Salon")
        ratings.set(4.5f)
        time.set("April 06, 2022, 9:58 AM")
        serviceType.set("Makeup")
        custName.set("Robb Mathew")
        custPhone.set("9878987898")
        countryCode.set("91")

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
            R.id.ivChatIcon -> view.navigateWithId(R.id.bookingDetailsToChat)
            R.id.btnTrackBooking -> {
                if (isPast.get() == true){
                    view.navigateWithId(R.id.bookingDetailsToPayment)
                }else{
                    view.navigateWithId(R.id.bookingDetailsToTracking)
                }

            }
        }
    }
}