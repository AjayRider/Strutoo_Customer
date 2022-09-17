package com.strutoocustomer.customer.recycleradapter

import android.graphics.drawable.Drawable

data class DummyModel(
    var isSelected: Boolean = false,
    var desc: String? ="",
    var desc2: String? ="",
    var name: String = "",
    var dataValue: String = "",
    var statusOrder: String = "",
    var plus: String = "",
    var intValue: Int? =0,
    var filterType: Int = 1,
    var floatval: Float? = 0f,
    var isPast: Boolean = false,
    var isViewShow: Boolean = false,
    var childAdapter: RecyclerAdapter<DummyModel>? = null,
    var childSecondAdapter: RecyclerAdapter<DummyModel>? = null,
    var innerBookAdapter: RecyclerAdapter<DummyModel>? = null,
    var text: String? = "",
    var type: String? = "",
    var drawable: Drawable? = null
) : AbstractModel()

