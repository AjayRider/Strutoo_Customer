package com.strutoocustomer.customer.views.signup

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

   var isPhone = ObservableField(false)


    fun onClick(view: View){
        when(view.id){
            R.id.tvSignIn -> view.navigateWithId(R.id.action_signUp_to_signIn)
            R.id.btnContinue -> view.navigateWithId(R.id.action_signUp_to_otpVerify)
            R.id.tvContinuePhone -> isPhone.set(!isPhone.get()!!)
        }

    }
}