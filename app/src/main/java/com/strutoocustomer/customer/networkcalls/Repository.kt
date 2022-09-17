package com.strutoocustomer.customer.networkcalls

import android.util.Log
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.datastore.TOKEN
import com.strutoocustomer.customer.datastore.DataStoreUtil
import com.strutoocustomer.customer.utils.sessionExpired
import com.strutoocustomer.networkcalls.ApiEnums
import com.strutoocustomer.networkcalls.ApiProcessor
import com.strutoocustomer.networkcalls.CacheUtil
import com.strutoocustomer.utils.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject


class Repository @Inject constructor(
    private val retrofitApi: RetrofitApi,
    private val cacheUtil: CacheUtil<String, Response<Any>>,
    private val dataStoreUtil: DataStoreUtil
) {
    fun <T> makeCall(
        apiKey: ApiEnums,
        loader: Boolean,
        requestProcessor: ApiProcessor<Response<T>>,
        saveInCache: Boolean = false,
        getFromCache: Boolean = false
    ) {
        dataStoreUtil.readData(TOKEN) {
            if (getFromCache)
                cacheUtil[apiKey.name + it]?.let {
                    requestProcessor.onResponse(it as Response<T>)
                } ?: getResponseFromCall(apiKey, loader, saveInCache, requestProcessor, it ?: "")
            else
                getResponseFromCall(apiKey, loader, saveInCache, requestProcessor, it ?: "")
        }

    }

    private fun <T> getResponseFromCall(
        apiKey: ApiEnums,
        loader: Boolean,
        saveInCache: Boolean,
        requestProcessor: ApiProcessor<Response<T>>,
        auth: String
    ) {
        try {
            val activity = MainActivity.context.get()

            activity?.let { activity ->
                if (!InternetLocationUtil.isNetworkAvailable(activity)) {
                    showToast(activity.getString(R.string.your_device_offline))
                    return
                }

                if (loader) {
                    showProgress()
                }
                val dataResponse: Flow<Response<Any>> = flow {
                    val response =
                        requestProcessor.sendRequest(retrofitApi) as Response<Any>
                    emit(response)
                }.flowOn(Dispatchers.IO)


                CoroutineScope(Dispatchers.Main).launch {
                    dataResponse.catch { exception ->
                        exception.printStackTrace()
                        hideProgress()
                        showToast(exception.message ?: "")
                    }.collect { response ->
                        Log.d("resCodeIs", "====${response.code()}")
                        hideProgress()
                        when {
                            response.code() in 100..199 -> {
                                /**Informational*/
                                requestProcessor.onError(
                                    activity.resources?.getString(R.string.some_error_occured) ?: ""
                                )
                                showToast(
                                    activity.resources?.getString(R.string.some_error_occured) ?: ""
                                )
                            }
                            response.isSuccessful -> {
                                /**Success*/
                                if (saveInCache)
                                    cacheUtil.put(
                                        apiKey.name + auth,
                                        response
                                    )

                                Log.d("successBody", "====${response.body()}")
                                requestProcessor.onResponse(response as Response<T>)
                            }
                            response.code() in 300..399 -> {
                                /**Redirection*/
                                requestProcessor.onError(
                                    activity.resources?.getString(R.string.some_error_occured) ?: ""
                                )
                                showToast(
                                    activity.resources?.getString(R.string.some_error_occured) ?: ""
                                )
                            }
                            response.code() == 401 -> {
                                /**UnAuthorized*/
                                Log.d("errorBody", "====${response.errorBody()?.string()}")
                                getRefreshToken()
                                sessionExpired()
                                requestProcessor.onError("unAuthorized")
                                dataStoreUtil.clearDataStore { }
                                activity.sessionExpired()
                            }
                            response.code() == 404 -> {
                                /**Page Not Found*/
                                requestProcessor.onError(
                                    activity.resources?.getString(R.string.some_error_occured) ?: ""
                                )
                                showToast(
                                    activity.resources?.getString(R.string.some_error_occured) ?: ""
                                )
                            }
                            response.code() in 500..599 -> {
                                /**ServerErrors*/
                                requestProcessor.onError(
                                    activity.resources?.getString(R.string.some_error_occured) ?: ""
                                )
                                showToast(
                                    activity.resources?.getString(R.string.some_error_occured) ?: ""
                                )
                            }
                            else -> {
                                /**ClientErrors*/
                                val res = response.errorBody()!!.string()
                                val jsonObject = JSONObject(res)
                                when {
                                    jsonObject.has("message") -> {
                                        requestProcessor.onError(jsonObject.getString("message"))

                                        if (!jsonObject.getString("message")
                                                .equals("Data not found", true)
                                        )
                                            showToast(jsonObject.getString("message"))
                                    }
                                    else -> {
                                        requestProcessor.onError(
                                            activity.resources?.getString(R.string.some_error_occured)
                                                ?: ""
                                        )
                                        showToast(
                                            activity.resources?.getString(R.string.some_error_occured)
                                                ?: ""
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            }


        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    private fun getRefreshToken() {}
}
