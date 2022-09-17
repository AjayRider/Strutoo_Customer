package com.strutoocustomer.customer.views.liveshows.golive

import android.view.LayoutInflater
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.strutoocustomer.MainActivity
import com.strutoocustomer.MainActivity.Companion.context
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.models.ChatModel
import com.strutoocustomer.customer.models.ProductModel
import com.strutoocustomer.customer.networkcalls.Repository
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.databinding.BottomsheetLiveProductBinding
import com.strutoocustomer.pref.PreferenceFile
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class GoLiveVM @Inject constructor(
    private val repository: Repository,
    private val dataStore: DataStoreUtil,
    private val preferences: PreferenceFile
) : ViewModel() {
    val productAdapter by lazy { RecyclerAdapter<ProductModel>(R.layout.item_product_live) }
    val productAdapter2 by lazy { RecyclerAdapter<DummyModel>(R.layout.item_product_manage) }
    val messagesAdapter by lazy { RecyclerAdapter<ChatModel>(R.layout.item_message_live) }
    var messageText = ObservableField("")

    init {
        productAdapter2.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
            )
        )
        productAdapter.addItems(
            listOf(
                ProductModel(
                    productName = "Creamy Lipshade",
                    price = 20f,
                    ratings = 4.5f,
                    offer = "20% OFF"
                ),
                ProductModel(
                    productName = "Creamy Nail polish",
                    price = 70f,
                    ratings = 4.8f,
                    offer = "18% OFF"
                )
            )
        )
        messagesAdapter.addItems(
            listOf(
                ChatModel(name = "Emily Stephen", designation = "Getting ready to start my day!!"),
                ChatModel(name = "travis_shreds18", designation = "So happy to see you back!")
            )
        )
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivSendMessage -> {
                if (!messageText.get()?.trim().isNullOrEmpty()) {
                    messagesAdapter.insertAt(
                        item = ChatModel(
                            name = "Jackqueline",
                            designation = "Makeup Artist",
                            messageByArtist = messageText.get()
                        )
                    )
                    messageText.set("")
                }
            }
            R.id.llShopAll -> {
               openProductBottomSheet()
            }
        }
    }

    var bottomSheetPrice: BottomSheetDialog? = null

    private fun openProductBottomSheet() {
        val binding =
            BottomsheetLiveProductBinding.inflate(LayoutInflater.from(MainActivity.context.get()!!))
        binding.vm = this
        binding.ivClose.setOnClickListener {
            bottomSheetPrice?.dismiss()
        }
        bottomSheetPrice = BottomSheetDialog(context.get()!!, R.style.CustomBottomSheetDialogTheme)
        bottomSheetPrice!!.setContentView(binding.root)
        bottomSheetPrice!!.show()
    }

}