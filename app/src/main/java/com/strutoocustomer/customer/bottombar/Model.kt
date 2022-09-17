package com.strutoocustomer.customer.bottombar

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.strutoocustomer.R

data class Model(
    @DrawableRes
    val icon: Int = 0,
    @IdRes
    val destinationId: Int = -1,
    val id: Int = -1,
    @StringRes
    val text: Int = 0,
    @StringRes
    var count: Int = R.string.empty_value
)