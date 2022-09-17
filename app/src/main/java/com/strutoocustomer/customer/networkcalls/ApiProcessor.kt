package com.strutoocustomer.networkcalls

import com.strutoocustomer.customer.networkcalls.RetrofitApi

interface ApiProcessor<T> {

    suspend fun sendRequest(retrofitApi: RetrofitApi): T

    fun onResponse(res: T)

    fun onError(message: String) {}

}