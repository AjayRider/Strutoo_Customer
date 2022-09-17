package com.strutoocustomer.customer.views.search

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    val recentAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_search) }
    val trendsAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_layout_search) }

    private var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when (view.id) {

        }
    }

    init {
        recentAdapter.setOnItemClick(adapterClick)
        trendsAdapter.setOnItemClick(adapterClick)

        recentAdapter.addItems(
            listOf(
                DummyModel(isSelected = true),
                DummyModel(isSelected = true), DummyModel(isSelected = true), DummyModel(isSelected = true), DummyModel(
                    isSelected = true)
            )
        )

        trendsAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(), DummyModel(), DummyModel(), DummyModel()
            )
        )


    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
        }
    }
}