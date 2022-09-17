package com.strutoocustomer.customer.models

import com.strutoocustomer.customer.recycleradapter.AbstractModel

data class ChatModel(
    var image: String? = "",
    var name: String? = "",
    var designation: String? = "",
    var messageByArtist: String? = "",
    var _id: String? = "",
): AbstractModel()