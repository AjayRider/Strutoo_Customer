package com.strutoocustomer.customer.views.addaddress

import android.view.View
import androidx.databinding.ObservableField
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModel
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.libraries.places.api.Places
import com.google.android.libraries.places.api.net.PlacesClient
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

enum class TabType {
    Home,
    Work,
    Other
}

@HiltViewModel
class AddAddressVM @Inject constructor() : ViewModel(), OnMapReadyCallback {
    val tabType = ObservableField(TabType.Home)
    private var gMap: GoogleMap? = null
    var mapFragment: SupportMapFragment? = null
    lateinit var placesClient: PlacesClient
    fun onClick(view: View) {
        when(view.id){
            R.id.ivBack -> view.navigateBack()
            R.id.btnAddAddress -> view.navigateBack()
            R.id.tabHome -> tabType.set(TabType.Home)
            R.id.tabWork -> tabType.set(TabType.Work)
            R.id.tabOther ->tabType.set(TabType.Other)
        }
    }

    fun setupPlaces() {
        if (!Places.isInitialized()) {
            Places.initialize(
                MainActivity.context.get()!!.applicationContext,
                "AIzaSyCNJWivcEuGZsfT5TX36bLdnSFpIfbFb7E"
            )
        }
        placesClient = Places.createClient(MainActivity.context.get()!!)
    }

    fun setUpMap(childFragmentManager: FragmentManager) {
        mapFragment =
            childFragmentManager.findFragmentById(R.id.frameMapAddress) as SupportMapFragment?
        mapFragment?.getMapAsync(this)
    }


    override fun onMapReady(mMap: GoogleMap) {
        mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        mMap.uiSettings.isCompassEnabled = false
        mMap.uiSettings.isTiltGesturesEnabled = false
        gMap = mMap

    }


}