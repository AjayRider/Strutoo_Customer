package com.strutoocustomer.customer.views.payment

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentVM @Inject constructor() : ViewModel() {
    val adapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_payment_type) }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
            R.id.tvPayNow -> view.navigateWithId(R.id.paymentToPaymentDone)
        }
    }

    init {
        adapter.addItems(
            listOf(
                DummyModel()
            )
        )
    }

}