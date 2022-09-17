package com.strutoocustomer.customer.views.singin

import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateWithId
import com.strutoocustomer.utils.showToast
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    var country = ObservableField("EGP")

    fun onClick(view:View){
        when(view.id){
            R.id.tvLanguage -> showPopup(view)
            R.id.tvSignUp -> view.navigateWithId(R.id.action_signIn_to_signUp)
            R.id.tvForgotPassword -> view.navigateWithId(R.id.action_signIn_to_forgot)
            R.id.btnSignIn -> view.navigateWithId(R.id.action_signIn_to_home)
        }

    }

    private fun showPopup(view: View) {
        val popup = PopupMenu(MainActivity.context.get()!!, view)
        popup.inflate(R.menu.language)

        popup.setOnMenuItemClickListener(PopupMenu.OnMenuItemClickListener { item: MenuItem? ->
            when (item!!.itemId) {
                R.id.EGP -> {
                    country.set("EGP")
//                   showToast("EGP")
                }
                R.id.IND -> {
                    country.set("IND")
//                    showToast("IND")
                }
            }
            true
        })
        popup.show()
    }

}