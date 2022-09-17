package com.strutoocustomer.customer.views.walkthrough.book

import android.view.View
import androidx.lifecycle.ViewModel
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.pref.PreferenceFile
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WalkThroughBookVM @Inject constructor(
    private val repository: Repository,
    private val preferenceFile: PreferenceFile,
    private val dataStore: DataStoreUtil
) : ViewModel() {

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivNext -> view.navigateWithId(R.id.action_book_to_watch)
            R.id.tvSkip -> view.navigateWithId(R.id.walkThroughBookToSignUp)
        }
    }
}