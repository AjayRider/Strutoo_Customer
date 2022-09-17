package com.strutoocustomer.customer.views.rateexperience

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RateExperienceVM @Inject constructor():ViewModel() {

    fun onClick(view: View){
        when(view.id){
            R.id.ivCrossRate -> view.navigateWithId(R.id.rateExperienceToBooking)
            R.id.tvSkip ->view.navigateWithId(R.id.rateExperienceToBooking)
            R.id.btnSubmitRateProduct ->view.navigateWithId(R.id.rateExperienceToBooking)
        }
    }
}