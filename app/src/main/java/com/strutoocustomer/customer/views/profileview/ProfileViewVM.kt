package com.strutoocustomer.customer.views.profileview

import android.os.Bundle
import android.view.View
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    var isInfluencer = ObservableBoolean(false)
    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
            R.id.tvViewProfile -> {
                val bundle = Bundle()
                if (isInfluencer.get()) {
                    bundle.putString("comes", "in")
                } else {
                    bundle.putString("comes", "ar")
                }
                view.navigateWithId(R.id.profileViewToProfileViewDetails,bundle)
            }
        }
    }


}

