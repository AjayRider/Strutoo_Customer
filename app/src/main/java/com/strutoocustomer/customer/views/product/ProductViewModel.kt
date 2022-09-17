package com.strutoocustomer.customer.views.product

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableField
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.interfaces.OnItemClickListener
import com.strutoocustomer.customer.models.SalonBanner
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) :ViewModel(),OnItemClickListener {
    val imageAdapter: RecyclerAdapter<SalonBanner> = RecyclerAdapter(R.layout.vp_image_view)
    val goToBooking = ObservableField(false)

    init {

        MainActivity.onItemClick = this
        MainActivity.context.get()?.let {
            val temp = arrayListOf<SalonBanner>()
            ContextCompat.getDrawable(it, R.drawable.image_333)
                ?.let { it1 -> SalonBanner(banner = it1) }?.let { banner ->
                    temp.add(banner)
                    temp.add(banner)
                    temp.add(banner)
                }
            imageAdapter.addItems(temp)
        }

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBackProduct -> view.navigateBack()
            R.id.ivBooking -> view.navigateWithId(R.id.productToBookings)
            R.id.btnContinue -> view.navigateWithId(R.id.productToBookings)
        }

    }

    override fun onPerformClick() {
        goToBooking.set(true)
    }

}