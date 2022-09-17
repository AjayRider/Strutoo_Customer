package com.strutoocustomer.customer.models

import com.google.gson.annotations.SerializedName
import com.strutoocustomer.customer.recycleradapter.AbstractModel

data class ChatScreenModel(

    val count: Int,
    val noOfPages: Int,
    val bookingId: String,
    @SerializedName("data") val chatLst: List<ChatItemModel>,
    val user: UserModel,
    val message: String
): AbstractModel()

data class ChatItemModel(
    val _id: String,
    @SerializedName("text", alternate = ["message"]) val text: String = "",
    @SerializedName("bookingId") val bookingId: String = "",
    var time: String = "",
    val sender: String = "",
    val receiver: String = "",
    @SerializedName("isReaded") val isRead: Boolean = false,
    val isDeleted: Boolean = false,

    var smallTime: String? = "",
    var myIdentification: String,
): AbstractModel()

data class socketNewMessageModel(
    val data: ChatItemModel,
    val message: ChatItemModel,
    val receiver: String = "",
    val sender: String = ""
)