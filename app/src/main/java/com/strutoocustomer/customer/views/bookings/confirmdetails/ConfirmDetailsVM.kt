package com.strutoocustomer.customer.views.bookings.confirmdetails

import android.app.Dialog
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.databinding.ConfirmScreenDialogBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ConfirmDetailsVM @Inject constructor() : ViewModel() {
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

    val confirmBookingAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_confirm_detail) }
    var adapter = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){

        }
    }

    init {
        confirmBookingAdapter.addItems(
            listOf(
                DummyModel(
                    text = "Hair Cut",
                    desc = "Salena"
                ),
                DummyModel(
                    text = "Hair Color",
                    desc = "Salena"
                ),
                DummyModel(
                    text = "Nail Makeover",
                    desc = "Salena"
                )
            )
        )
        title.set("Curlz Unisex Salon")
        ratings.set(4.5f)
        time.set("April 06, 2022, 9:58 AM")
        serviceType.set("Makeup")
        custName.set("Robb Mathew")
        custPhone.set("9878987898")
        countryCode.set("91")

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> Navigation.findNavController(view).navigateUp()
            R.id.btnConfirmBooking -> {
                showSuccessDialogFullScreen(view)
            }
        }
    }

    private fun showSuccessDialogFullScreen(vw: View) {
        MainActivity.context.get()?.let { context ->
            val builder = Dialog(context, R.style.FullScreenDialog)
            val view = ConfirmScreenDialogBinding.inflate(LayoutInflater.from(context))
            builder.setContentView(view.root)

            view.provideTitle.text = context.getString(R.string.booking_confirmed)

            view.provideMessage.text = context.getString(R.string.congo_booking_confirm)

            builder?.setCancelable(true)
            builder?.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )

            builder.show()

            CoroutineScope(Dispatchers.IO).launch {
                delay(2000)
                CoroutineScope(Dispatchers.Main).launch {
                    builder.dismiss()
                    vw.findNavController().navigate(R.id.book)
                }
            }

        }

    }
}