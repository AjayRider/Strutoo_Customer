package com.strutoocustomer.customer.views.orderfilter

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class OrderFilterVM @Inject constructor():ViewModel() {

    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
            R.id.btnApplyFilter -> view.navigateBack()
        }
    }
}