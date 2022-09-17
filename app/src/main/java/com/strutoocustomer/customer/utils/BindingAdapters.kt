package com.strutoocustomer.customer.utils

import android.content.res.ColorStateList
import android.graphics.Paint
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout
import com.hbb20.CountryCodePicker
import com.mukesh.mukeshotpview.completeListener.MukeshOtpCompleteListener
import com.mukesh.mukeshotpview.mukeshOtpView.MukeshOtpView
import com.squareup.picasso.Picasso
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

/** Binding Adapters */
object BindingAdapters {

    @BindingAdapter(value = ["setRecyclerAdapter"], requireAll = false)
    @JvmStatic
    fun setRecyclerAdapter(
        recyclerView: RecyclerView,
        adapter: RecyclerView.Adapter<*>?
    ) {
        recyclerView.adapter = adapter
    }

    @BindingAdapter(value = ["setViewPagerAdapter", "addDotIndicator"], requireAll = false)
    @JvmStatic
    fun setViewPagerAdapter(
        view: ViewPager2,
        adapter: RecyclerView.Adapter<*>,
        dotsIndicator: WormDotsIndicator?

    ) {
        view.adapter = adapter
            dotsIndicator?.setViewPager2(view)
    }

    @BindingAdapter(value = ["addIndicator"], requireAll = false)
    @JvmStatic
    fun addIndicator(
        view: SpringDotsIndicator?,
        viewPager: ViewPager2,
    ) {
        try {
            view?.setViewPager2(viewPager)
        }catch (e :Exception){
            e.printStackTrace()
        }

    }


    @BindingAdapter(value = ["addScrollListener"], requireAll = false)
    @JvmStatic
    fun addScrollListener(
        recyclerView: RecyclerView,
        listener: RecyclerView.OnScrollListener
    ) {
        recyclerView.addOnScrollListener(listener)
    }

    @BindingAdapter(value = ["otpListener"], requireAll = false)
    @JvmStatic
    fun otpListener(
        otpView: MukeshOtpView,
        listener: MukeshOtpCompleteListener
    ) {
        otpView.setOtpCompletionListener(listener)
    }

    @BindingAdapter(value = ["bottomNavigationListener"], requireAll = false)
    @JvmStatic
    fun bottomNavigationListener(
        bottomNavigationView: BottomNavigationView,
        listener: BottomNavigationView.OnNavigationItemSelectedListener
    ) {
        bottomNavigationView.setOnNavigationItemSelectedListener(listener)
    }

    @BindingAdapter(value = ["setColorOfText"], requireAll = false)
    @JvmStatic
    fun setColorOfText(
        textView: TextView,
        color: Int
    ) {
        textView.setTextColor(textView.context.getColor(color))
    }

    @BindingAdapter(value = ["onCheckChange"], requireAll = false)
    @JvmStatic
    fun onCheckChange(
        compoundButton: CompoundButton,
        listener: CompoundButton.OnCheckedChangeListener
    ) {
        compoundButton.setOnCheckedChangeListener(listener)
    }

    @BindingAdapter(value = ["setImageUrl"], requireAll = false)
    @JvmStatic
    fun setImageUrl(
        imageView: ImageView,
        url: String?
    ) {
        Log.d("ImageUrlIs", "+=======$url")
        when {
            url?.startsWith("/storage")!! -> Picasso.get().load(url).into(imageView)
            else -> Picasso.get().load(url).into(imageView)
        }

    }

    @BindingAdapter(value = ["setDrawable"], requireAll = false)
    @JvmStatic
    fun setDrawable(
        imageView: ImageView,
        drawable: Int
    ) {
        imageView.setImageResource(drawable)
    }

    @BindingAdapter(value = ["setBackground"], requireAll = false)
    @JvmStatic
    fun setBackground(
        view: View,
        drawable: Int
    ) {
        view.background = ContextCompat.getDrawable(view.context, drawable)
    }

    @BindingAdapter(value = ["radioGroupListener"], requireAll = false)
    @JvmStatic
    fun radioGroupListener(
        view: RadioGroup,
        listener: RadioGroup.OnCheckedChangeListener
    ) {
        view.setOnCheckedChangeListener(listener)
    }

    @BindingAdapter(value = ["addTextWatcher"], requireAll = false)
    @JvmStatic
    fun addTextWatcher(
        view: EditText,
        listener: TextWatcher
    ) {
        view.addTextChangedListener(listener)
    }


    @JvmStatic
    @BindingAdapter("buttonBackTint")
    fun setButtonBackTint(button: TextView, color: Int?) {
        color?.let {
            if (color != 1) button.backgroundTintList = ColorStateList.valueOf(it)
        }
    }

    @BindingAdapter(value = ["ccpValue"], requireAll = false)
    @JvmStatic
    fun setCcpValue(ccp: CountryCodePicker, observeValue: ObservableField<String>?) {
        observeValue?.let {
            try {
                if (observeValue.get()!!.isEmpty()) {
                    observeValue.set(ccp.defaultCountryCodeWithPlus)
                } else {
                    if (observeValue.get()!!.contains("+")) {
                        val temp = observeValue.get()!!.replace("+", "")
                        ccp.setCountryForPhoneCode(temp.toInt())
                    } else {
                        ccp.setCountryForPhoneCode(observeValue.get()!!.toInt())
                    }
                }
                ccp.setOnCountryChangeListener { observeValue.set(ccp.selectedCountryCodeWithPlus) }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    @BindingAdapter(value = ["tabSelectListener"], requireAll = false)
    @JvmStatic
    fun tabSelectListener(
        view: TabLayout,
        listener: TabLayout.OnTabSelectedListener
    ) {
        view.addOnTabSelectedListener(listener)
    }

    @BindingAdapter(value = ["spaceStart", "spaceEnd"], requireAll = false)
    @JvmStatic
    fun setSpaceEachTab(
        view: TabLayout?,
        start: Int,
        end: Int
    ) {
        val tabs = view?.getChildAt(0) as ViewGroup
        for (i in 0 until tabs.childCount) {
            val tab = tabs.getChildAt(i)
            val layoutParams = tab.layoutParams as LinearLayout.LayoutParams
            layoutParams.marginEnd = end
            layoutParams.marginStart = start
            tab.layoutParams = layoutParams
            view.requestLayout()
        }
    }

    @BindingAdapter(value = ["textColorByStatus"], requireAll = false)
    @JvmStatic
    fun textColorByStatus(
        view: TextView,
        status: Int?
    ) {
        status?.let {
            when (status) {
                1 -> view.setTextColor(ColorStateList.valueOf(
                    ContextCompat.getColor(
                        MainActivity.context.get()!!,
                        R.color.green
                    )
                ))
                else -> view.setTextColor(ColorStateList.valueOf(
                    ContextCompat.getColor(
                        MainActivity.context.get()!!,
                        R.color._4fe8f2
                    )
                ))
            }
        }
    }

    @BindingAdapter(value = ["crossText"], requireAll = false)
    @JvmStatic
    fun crossText(view: AppCompatTextView?, isCut: Boolean) {
        try {
            if (isCut) {
                view?.paintFlags = view?.paintFlags?.or(Paint.STRIKE_THRU_TEXT_FLAG)!!
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}