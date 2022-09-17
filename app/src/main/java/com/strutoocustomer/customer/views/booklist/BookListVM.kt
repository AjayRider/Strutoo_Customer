package com.strutoocustomer.customer.views.booklist

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BookListVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {
    val bookListAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_book_list) }

    var adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
        when(view.id){
            R.id.layoutBookItem -> {view.navigateWithId(R.id.bookListToProduct)}
        }


    }
    val searchQuery = ObservableField("")

    init {
        bookListAdapter.setOnItemClick(adapterClick)
        bookListAdapter.addItems(listOf(
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
            DummyModel(),
        ))
    }

    fun onClick(view: View) {
        when(view.id) {
            R.id.ivBack -> view.navigateBack()
            R.id.ivFilterIcon -> view.navigateWithId(R.id.bookListToFilters)
            R.id.ivCalander -> view.navigateWithId(R.id.bookListToBookings)
        }

    }

}