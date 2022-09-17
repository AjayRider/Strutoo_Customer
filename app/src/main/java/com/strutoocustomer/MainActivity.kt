package com.strutoocustomer

import android.annotation.SuppressLint
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.install.model.ActivityResult
import com.google.android.play.core.install.model.AppUpdateType
import com.google.android.play.core.install.model.UpdateAvailability
import com.strutoocustomer.customer.bottombar.Model
import com.strutoocustomer.customer.interfaces.NavigationListener
import com.strutoocustomer.customer.interfaces.OnItemClickListener
import com.strutoocustomer.customer.utils.statusBarColor
import com.strutoocustomer.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import java.lang.ref.WeakReference

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationListener, OnItemClickListener {

    lateinit var binding: ActivityMainBinding
    private val mainVM: MainVM by viewModels()

    companion object {
        lateinit var context: WeakReference<Context>
        var navListener: NavigationListener? = null
        var onItemClick: OnItemClickListener? = null
    }

    override fun onStart() {
        super.onStart()
        context = WeakReference(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        mainVM.navController = findNavController(R.id.fragmentMain)
        binding.model = mainVM
        navListener = this
        onItemClick = this
        binding.drawerLayout.setScrimColor(Color.TRANSPARENT)
        checkUpdate()
        setBottomNavigationWithNavController(savedInstanceState)
        statusBarColor(Color.BLACK)
//        NavigationUI.setupWithNavController(binding.bottomNav, mainVM.navController)
//        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
//            if (item.itemId != binding.bottomNav.selectedItemId)
//                NavigationUI.onNavDestinationSelected(item, mainVM.navController)
//            when (item.itemId) {
//                R.id.home -> {
//
//                }
//            }
//            true
//        }
    }

    private fun setBottomNavigationWithNavController(savedInstanceState: Bundle?) {

        // If you don't pass activeIndex then by default it will take 0 position
        val activeIndex = savedInstanceState?.getInt("activeIndex") ?: 2
        val menuItems = arrayOf(
            Model(
                icon = R.drawable.ic_home,
                destinationId = R.id.home,
                id = 0,
                text = R.string.empty,
                count = R.string.empty_value
            ),
            Model(
                R.drawable.ic_shop,
                R.id.shop,
                id = 1,
                R.string.empty,
                R.string.empty_value
            ),
            Model(
                R.drawable.ic_studio,
                R.id.studio,
                2,
                R.string.empty,
                R.string.empty_value
            ),
            Model(
                R.drawable.ic_book,
                R.id.book,
                3,
                R.string.empty,
                R.string.empty_value
            ),
            Model(
                R.drawable.ic_profile,
                R.id.profile,
                4,
                R.string.empty,
                R.string.empty_value
            )
        )

        binding.bottomNav.apply {
            // If you don't pass activeIndex then by default it will take 0 position
            setMenuItems(menuItems, activeIndex)
            setupWithNavController(mainVM.navController)
            //    setCount(ID_NOTIFICATION, R.string.empty)
        }

    }

    /**
     * override onBackPressed method
     * */
    @SuppressLint("RestrictedApi")
    override fun onBackPressed() {
        when (mainVM.navController.currentDestination?.id!!) {
            R.id.home -> {
                showExit()
            }
            R.id.shop,R.id.studio,R.id.book,R.id.profile -> {
                mainVM.navController.popBackStack(R.id.strutoo_customer, true)
                mainVM.navController.navigate(R.id.home)
            }
            else -> {
                super.onBackPressed()
            }
        }
    }

    /***
     * Check app update from playstore
     * */
    private fun checkUpdate() {
        val appUpdateManager: AppUpdateManager = AppUpdateManagerFactory.create(this)
        appUpdateManager
            .appUpdateInfo
            .addOnSuccessListener { appUpdateInfo ->
                if (appUpdateInfo.updateAvailability()
                    == UpdateAvailability.UPDATE_AVAILABLE
                ) {
                    // If an in-app update is already running, resume the update.
                    appUpdateManager.startUpdateFlowForResult(
                        appUpdateInfo,
                        AppUpdateType.IMMEDIATE,
                        this,
                        1234
                    )
                }
            }
    }

    /***
     * Override result method
     * */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            1234 -> {
                val TAG = "null"
                when (resultCode) {
                    Activity.RESULT_OK -> {
                        Log.d(TAG, "" + "Result Ok")
                        //  handle user's approval }
                    }
                    Activity.RESULT_CANCELED -> {
                        Log.d(TAG, "" + "Result Cancelled")
                        //  handle user's rejection  }
                    }
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED -> {
                        //if you want to request the update again just call checkUpdate()
                        Log.d(TAG, "" + "Update Failure")
                        //  handle update failure
                    }
                }
            }
        }
    }

    private fun showExit() {
        val aD = AlertDialog.Builder(this)
        aD.setTitle(getString(R.string.exit_message))
        aD.setCancelable(false)
        aD.setPositiveButton(getString(R.string.ok)) { dialogInterface, i ->
            dialogInterface.cancel()
            dialogInterface.dismiss()
            finishAffinity()
        }
        aD.setNegativeButton(getString(R.string.cancel)) { dialogInterface, i ->
            dialogInterface.cancel()
            dialogInterface.dismiss()
        }
        aD.create()
        aD.show()
    }

    override fun bottomNav(visibility: Boolean) {
        if (visibility) {
            binding.bottomNav.visibility = View.VISIBLE
        } else {
            binding.bottomNav.visibility = View.GONE
        }
    }

    override fun bottomNavLocation(position: Int) {

    }

    override fun isLockDrawer(isLock: Boolean) {
        if (isLock) {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        } else {
            binding.drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        }
    }

    override fun openDrawer() {
        try {
            if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayout.closeDrawer(GravityCompat.START)
            } else {
                binding.drawerLayout.openDrawer(GravityCompat.START)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onPerformClick() {}

}