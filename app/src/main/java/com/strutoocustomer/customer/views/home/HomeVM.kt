package com.strutoocustomer.customer.views.home

import android.Manifest
import android.content.Context
import android.view.View
import androidx.lifecycle.ViewModel
import com.nabinbhandari.android.permissions.PermissionHandler
import com.nabinbhandari.android.permissions.Permissions
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {
    val serviceAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_service_type) }
    val bannerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_banner) }
    val studioAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_studio) }
    val brandAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_brands) }
    val salonAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_salons) }
    val storeAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_store) }
    val sellerAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_seller) }
    val looksAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_looks) }
    val clearanceAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_clearance_sale) }
    val offersAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_offers) }
    val arrivalAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_arrival) }

    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {
            R.id.clService -> view.navigateWithId(R.id.homeToServiceDetailStore)
            R.id.clStudio -> view.navigateWithId(R.id.homeToProfileView)
            R.id.ivBrag -> view.navigateWithId(R.id.homeToServiceDetailStore)
            R.id.clBrand -> view.navigateWithId(R.id.shopProducts)
            R.id.cvSalon -> view.navigateWithId(R.id.homeToProduct)
        }
    }


    init {
        serviceAdapter.setOnItemClick(adapterClick)
        bannerAdapter.setOnItemClick(adapterClick)
        studioAdapter.setOnItemClick(adapterClick)
        brandAdapter.setOnItemClick(adapterClick)
        salonAdapter.setOnItemClick(adapterClick)
        storeAdapter.setOnItemClick(adapterClick)
        sellerAdapter.setOnItemClick(adapterClick)
        looksAdapter.setOnItemClick(adapterClick)
        clearanceAdapter.setOnItemClick(adapterClick)
        offersAdapter.setOnItemClick(adapterClick)
        arrivalAdapter.setOnItemClick(adapterClick)

        serviceAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel(),
                DummyModel(), DummyModel(), DummyModel(), DummyModel(), DummyModel()
            )
        )
        bannerAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel()
            )
        )
        studioAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel(),
                DummyModel(), DummyModel()
            )
        )
        brandAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel()
            )
        )
        salonAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel(),
                DummyModel(), DummyModel()
            )
        )
        storeAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel()

            )
        )
        sellerAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel(),
                DummyModel(), DummyModel()
            )
        )
        looksAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel(),
                DummyModel(), DummyModel()
            )
        )
        clearanceAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel()
            )
        )
        offersAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel(),
                DummyModel(), DummyModel()
            )
        )
        arrivalAdapter.addItems(
            listOf(
                DummyModel(), DummyModel(), DummyModel(), DummyModel(),
                DummyModel(), DummyModel()
            )
        )
    }


    fun onClick(view: View) {
        when (view.id) {
            R.id.tvScanner -> checkPermission(view)
            R.id.ivCart -> view.navigateWithId(R.id.homeToCart)
            R.id.clSearch -> view.navigateWithId(R.id.homeToSearch)
            R.id.ivDrawer -> MainActivity.navListener?.openDrawer()
        }
    }

    private fun checkPermission(view:View) {
        val permissions =
            arrayOf(
                Manifest.permission.CAMERA
            )
        Permissions.check(
            view.context,
            permissions,
            null, null,
            object : PermissionHandler() {
                override fun onGranted() {
                    view.navigateWithId(R.id.homeToScanner)
                }

                override fun onDenied(
                    context: Context?,
                    deniedPermissions: java.util.ArrayList<String>?
                ) {
                    super.onDenied(context, deniedPermissions)
                }
            })
    }

}