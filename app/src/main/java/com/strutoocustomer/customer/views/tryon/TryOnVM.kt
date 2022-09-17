package com.strutoocustomer.customer.views.tryon

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TryOnVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
):ViewModel() {

    val adapterShades by lazy { RecyclerAdapter<DummyModel>(R.layout.item_shades) }
    var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){

        }
    }

    init {
        adapterShades.setOnItemClick(adapterClick)
        adapterShades.addItems(listOf(DummyModel(),
            DummyModel(), DummyModel
        (), DummyModel
        ()
        ))
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.ivBack -> view.navigateBack()
        }

    }
}