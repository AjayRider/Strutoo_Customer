package com.strutoocustomer.customer.views.myorder.suborderdetail

import android.view.LayoutInflater
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.databinding.BottomsheetCancelOrderBinding
import com.strutoocustomer.databinding.BottomsheetRefundProcessBinding
import com.strutoocustomer.utils.navigateBack
import com.strutoocustomer.utils.navigateWithId
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SuborderDetailVM @Inject constructor() : ViewModel() {
    var cancelOrderBinding: BottomsheetCancelOrderBinding? = null
    var refundInfoBinding: BottomsheetRefundProcessBinding? = null
    val orderStatusAdapter by lazy { RecyclerAdapter<DummyModel>(R.layout.item_order_status) }
    val isPast = ObservableField(false)

    fun setupdata() {

    }

    init {
        orderStatusAdapter.addItems(listOf(
            DummyModel(
                text = "Order  and Approved",
                desc = "Your order has been placed",
                desc2 = "Sat,14th dec,19", isViewShow = true),
            DummyModel(
                text = "Ready",
                desc = "Seller has processed your order",
                desc2 = "Sat,14th dec,19", isViewShow = true),
            DummyModel(
                text = "Dispatched",
                desc = "Your item in out for delivery",
                desc2 = "Sat,16th dec,19", isViewShow = true),
            DummyModel(text = "Delivered", isViewShow = false)
        ))

    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.ivBack -> view.navigateBack()
            R.id.btnCancelOrder -> showCancelOrderBottomSheet()
            R.id.btnRepeat -> view.navigateWithId(R.id.shopProductDetails)
            R.id.btnReturn -> showCancelOrderBottomSheet(true)
        }
    }


    private fun showCancelOrderBottomSheet(isReturn: Boolean = false) {
        val bottomSheet =
            BottomSheetDialog(MainActivity.context.get()!!, R.style.CustomBottomSheetDialogTheme)
        cancelOrderBinding =
            BottomsheetCancelOrderBinding.inflate(LayoutInflater.from(MainActivity.context.get()))

        if (isReturn) {
            cancelOrderBinding?.tvTitle?.text = "Return Order"
            cancelOrderBinding?.tvButton?.text = "Request Refund"
        }


        cancelOrderBinding!!.clReason.setOnClickListener {


        }

        cancelOrderBinding!!.ivCloseBottom.setOnClickListener {

            bottomSheet.dismiss()
        }

        cancelOrderBinding!!.tvButton.setOnClickListener {
            bottomSheet.dismiss()
            if (isReturn) {
                showBottomSheetInfo()
            }

        }

        bottomSheet.setContentView(cancelOrderBinding!!.root)
        bottomSheet.show()
    }

    private fun showBottomSheetInfo() {
        val bottomSheet =
            BottomSheetDialog(MainActivity.context.get()!!, R.style.CustomBottomSheetDialogTheme)
        refundInfoBinding =
            BottomsheetRefundProcessBinding.inflate(LayoutInflater.from(MainActivity.context.get()))

        refundInfoBinding!!.tvButton.setOnClickListener {
            bottomSheet.dismiss()
        }

        bottomSheet.setContentView(refundInfoBinding!!.root)
        bottomSheet.show()
    }
}