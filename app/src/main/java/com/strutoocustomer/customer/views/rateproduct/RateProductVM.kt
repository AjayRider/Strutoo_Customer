package com.strutoocustomer.customer.views.rateproduct

import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class RateProductVM @Inject constructor() : ViewModel() {

    var isConfirmed = ObservableBoolean(false)

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBackProduct ->{
                view.navigateBack()
            }
            R.id.ivCrossRate ->{
                view.navigateBack()
            }
            R.id.btnSubmitRateProduct ->{
                view.navigateBack()
            }
        }
    }
}