package com.strutoocustomer.customer.recycleradapter

import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter

abstract class AbstractModel{
    var adapterPosition: Int = -1
    var onItemClick: RecyclerAdapter.OnItemClick? = null
}