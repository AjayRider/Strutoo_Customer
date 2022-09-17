package com.strutoocustomer

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.strutoocustomer.MainActivity.Companion.navListener
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    lateinit var navController: NavController

    fun onClick(view: View) {
        when(view.id){

            R.id.ivBackButtonPromo -> {
                navListener?.openDrawer()
            }

            R.id.tvShopAllCategory -> {
                navController.popBackStack(R.id.strutoo_customer, true)
                navController.navigate(R.id.shop)
                navListener?.openDrawer()
            }
            R.id.tvShopByBrands -> {
                navController.popBackStack(R.id.strutoo_customer, true)
                navController.navigate(R.id.shop)
                navListener?.openDrawer()
            }
            R.id.tvStudioDrawer -> {
                navController.popBackStack(R.id.strutoo_customer, true)
                navController.navigate(R.id.studio)
                navListener?.openDrawer()
            }
            R.id.tvBeautyServices -> {
                navController.popBackStack(R.id.strutoo_customer, true)
                navController.navigate(R.id.book)
                navListener?.openDrawer()
            }
            R.id.tvBragDrawer -> {
                navController.navigate(R.id.serviceDetailStore)
                navListener?.openDrawer()
            }
            R.id.tvOffersDrawer -> {
                navController.navigate(R.id.offers)
                navListener?.openDrawer()
            }
            R.id.tvContactUsDrawer -> {
                navController.navigate(R.id.contactUs)
                navListener?.openDrawer()
            }
            R.id.tvCustomerService -> {
                navListener?.openDrawer()
            }
            R.id.tvTermsPrivacy -> {
                navListener?.openDrawer()
            }
            R.id.tvAboutStrutoo -> {
                navListener?.openDrawer()
            }
            R.id.ivDrawerFb -> {
                navListener?.openDrawer()
            }
            R.id.ivDrawerInsta -> {
                navListener?.openDrawer()
            }
            R.id.ivDrawerYoutube -> {
                navListener?.openDrawer()
            }
            R.id.tvTiktok -> {
                navListener?.openDrawer()
            }
            R.id.tvLinkedIn -> {
                navListener?.openDrawer()
            }

        }

    }

    private fun showLogout(view: View) {
        val aD = android.app.AlertDialog.Builder(view.context)
        aD.setTitle(view.context.getString(R.string.are_your_sure_want_to_logout))
        aD.setCancelable(false)
        aD.setPositiveButton(view.context.getString(R.string.ok)) { dialogInterface, i ->
            dialogInterface.cancel()
            dialogInterface.dismiss()
            val bundle = Bundle().apply {
                putBoolean("isLogout", true)
            }
            navController.popBackStack(R.id.strutoo_customer, true)
          //  navController.navigate(R.id.login, bundle)
        }
        aD.setNegativeButton(view.context.getString(R.string.cancel)) { dialogInterface, i ->
            dialogInterface.cancel()
            dialogInterface.dismiss()
        }
        aD.create()
        aD.show()
    }

}
