package com.strutoocustomer.customer.views.countrynlanguage

import android.annotation.SuppressLint
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@SuppressLint("NotifyDataSetChanged")
@HiltViewModel
class CountryNLangVM @Inject constructor(): ViewModel() {
    val adapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_choose_country) }

    init {
        MainActivity.context.get()?.let {
//            adapter.addItems(
//                listOf(
//                    DummyModel(
//                        drawable = ContextCompat.getDrawable(it, R.drawable.ducjh_flag)!!,
//                        text = "Dutch"
//                    ),
//                    DummyModel(
//                        drawable = ContextCompat.getDrawable(it, R.drawable.germany_flag)!!,
//                        text = "German"
//                    ),
//                    DummyModel(
//                        drawable = ContextCompat.getDrawable(it, R.drawable.egypy_flag)!!,
//                        text = "Egypt"
//                    ),
//                    DummyModel(
//                        drawable = ContextCompat.getDrawable(it, R.drawable.italy_flag)!!,
//                        text = "Italian"
//                    ),
//                    DummyModel(
//                        drawable = ContextCompat.getDrawable(it, R.drawable.france_flag)!!,
//                        text = "French"
//                    )
//                )
//            )

            adapter.addItems(
                listOf(
                    DummyModel(
                        drawable = ContextCompat.getDrawable(it, R.drawable.egypy_flag)!!,
                        text = "Egypt"
                    )
                )
            )

            adapter.setOnItemClick { v, p, t ->
                adapter.getAllItems()[p].isSelected = !(adapter.getAllItems()[p].isSelected)
                adapter.notifyDataSetChanged()
            }
        }

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
        }
    }
}