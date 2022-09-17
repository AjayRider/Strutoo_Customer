package com.strutoocustomer.customer.views.chat

import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.models.ChatItemModel
import com.strutoocustomer.customer.models.UserModel
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChatVM @Inject constructor(
    val repository: Repository,
    val dataStore: DataStoreUtil,
) : ViewModel() {
    val orderNumber = MutableLiveData("")
    var myId: String = ""
    var bookingId = MutableLiveData("")
    val userModel = UserModel()

    val chatAdapter by lazy {
        RecyclerAdapter<ChatItemModel>(R.layout.item_chat)
    }
    var chatList = arrayListOf<ChatItemModel>()
    val messageText by lazy { ObservableField("") }
    var nextPAge: Int = 1
    var totalPages: Int = 1
    var isLoading = false
    var todayStarted = ""
    val scrollOnNewMessage by lazy { MutableLiveData<Boolean>(false) }

    init {
        chatAdapter.addItems(listOf(
            ChatItemModel(
                myIdentification = "1",
                text = "Hello jane",
                _id = "10",
                sender = "1"
            ),
            ChatItemModel(
                myIdentification = "2",
                text = "Hello",
                _id = "11",
                sender = "2"
            )
        ))
    }

    fun onClickBack(view: View) {
        Navigation.findNavController(view).popBackStack()
    }

    fun setTimeView(string: String) {

    }

}