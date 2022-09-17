package com.strutoocustomer.customer.views.profile

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    fun onClick(view: View) {
        when(view.id) {
            R.id.clCoupons -> view.navigateWithId(R.id.profileToPromoCode)
            R.id.clWishlist -> view.navigateWithId(R.id.profileToWishList)
            R.id.clBook -> view.navigateWithId(R.id.profileToBooking)
            R.id.clOrder -> view.navigateWithId(R.id.profileToMyOrders)
            R.id.clProfile -> view.navigateWithId(R.id.profileToEditProfile)
            R.id.ivprofilePhoto -> view.navigateWithId(R.id.profileToEditProfile)
            R.id.clMyAddress -> view.navigateWithId(R.id.profileToMyAddress)
            R.id.clCountryLanguage -> view.navigateWithId(R.id.profileToCountryNLanguage)
            R.id.clNotification -> view.navigateWithId(R.id.profileToNotification)
            R.id.clMyPayment -> view.navigateWithId(R.id.profileToPaymentMethod)
        }
    }
}