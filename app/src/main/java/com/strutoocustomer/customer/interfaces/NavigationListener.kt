package com.strutoocustomer.customer.interfaces

interface NavigationListener  {

    fun bottomNav(visibility: Boolean)
    fun bottomNavLocation(position:Int)
    fun isLockDrawer(isLock : Boolean)
    fun openDrawer()


}