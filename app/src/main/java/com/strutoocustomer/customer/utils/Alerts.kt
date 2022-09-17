package com.strutoocustomer.utils


import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.databinding.ProgressLayoutBinding

/**Session Expired Alert*/
fun sessionExpired(message: String? = null) {
    try {
        MainActivity.context.get()?.let { ctx ->
            val aD = AlertDialog.Builder(ctx)
            if (message == null)
                aD.setTitle(ctx.getString(R.string.session_expired))
            else
                aD.setTitle(message)
            aD.setCancelable(false)
            aD.setPositiveButton(ctx.getString(R.string.ok)) { dialogInterface, _ ->
                dialogInterface.dismiss()
                ctx.startActivity(Intent(ctx, MainActivity::class.java).putExtra("clear", true))
                (ctx as MainActivity).finishAffinity()
            }
            aD.create()
            aD.show()
        }
    } catch (e: Exception) {
        e.printStackTrace()
    }
}

/**Alert*/
fun showToast(message: String) = Toast.makeText(MainActivity.context.get(), message, Toast.LENGTH_SHORT).show()


/**Loader*/
private var customDialog: AlertDialog? = null
fun showProgress() {
    hideProgress()
    val customAlertBuilder = AlertDialog.Builder(MainActivity.context.get())
    val customAlertView =
        ProgressLayoutBinding.inflate(LayoutInflater.from(MainActivity.context.get()), null, false)
    customAlertBuilder.setView(customAlertView.root)
    customAlertBuilder.setCancelable(false)
    customDialog = customAlertBuilder.create()

    customDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
    customDialog?.show()
}

fun hideProgress() {
    if (customDialog != null && customDialog?.isShowing==true) {
        customDialog?.dismiss()
    }
}


