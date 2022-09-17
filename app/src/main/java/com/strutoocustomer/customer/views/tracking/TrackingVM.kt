package com.strutoocustomer.customer.views.tracking

import android.view.View
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

@HiltViewModel
class TrackingVM @Inject constructor():ViewModel(), OnMapReadyCallback {

    private var gMap: GoogleMap? = null
    var mapFragment: SupportMapFragment? = null
    lateinit var placesClient: PlacesClient

    fun onClick(view: View){
        when(view.id){
            R.id.ivBack -> view.navigateBack()
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