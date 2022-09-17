package com.strutoocustomer.customer.views.paymentdone

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PaymentDoneVM @Inject constructor():ViewModel() {

    fun onClick(view: View){
       when(view.id){

           R.id.tvRate -> view.navigateWithId(R.id.paymentDoneToRateExperience)
           R.id.tvSkip -> view.navigateWithId(R.id.paymentDoneToBooking)
       }
    }
}