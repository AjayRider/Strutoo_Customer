package com.strutoocustomer.customer.views.otpverify

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.databinding.DialogVerifyBinding
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OtpVerifyVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    var isShowResend = ObservableField(false)
    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
            R.id.btnContinue ->{ showVerifyDialog(view)
                CoroutineScope(Dispatchers.Main).launch {
                    delay(3000)
                    view.navigateWithId(R.id.otpVerifyToProfileSetup)
                }
            }
            R.id.tvResend -> isShowResend.set(true)
        }

    }


    private fun showVerifyDialog(view:View){
        val dialog = Dialog(view.context)
        val dialogBinding:DialogVerifyBinding = DataBindingUtil.inflate(LayoutInflater.from(view.context),R.layout.dialog_verify,null,false)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(dialogBinding.root)

//        val height =
//            (MainActivity.context.get()?.resources?.displayMetrics?.heightPixels?.times(0.50))?.toInt()
//        val width =
//            (MainActivity.context.get()?.resources?.displayMetrics?.widthPixels?.times(0.90))?.toInt()
//
//        dialog.window?.setLayout(
//            width ?: 0,
//            ViewGroup.LayoutParams.WRAP_CONTENT
//        )
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.show()
        CoroutineScope(Dispatchers.Main).launch {
            delay(2900)
            dialog.dismiss()
        }
    }
}