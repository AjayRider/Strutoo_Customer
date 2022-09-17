package com.strutoocustomer.customer.views.product.review

import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.models.PublicReviews
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReviewsViewModel @Inject constructor() :ViewModel() {
    val reviewAdapter = RecyclerAdapter<PublicReviews>(R.layout.public_review)



    init {
         reviewAdapter.addItems(
            listOf(
                PublicReviews(MainActivity
                    .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    "Emily " +
                            "Stephen",
                    "\"Just as Expected\"",
                    true,
                    "22-05-2022",
                    "I have oily skin. This primer covered my pores well and \n" +
                            "gave me a perfect base for my make-up. I had no breakouts using this product. Go" +
                            " for it.",
                    5,
                    25,
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) }),
                PublicReviews(MainActivity
                    .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    "Emily " +
                            "Stephen",
                    "\"Just as Expected\"",
                    true,
                    "22-05-2022",
                    "I have oily skin. This primer covered my pores well and \n" +
                            "gave me a perfect base for my make-up. I had no breakouts using this product. Go" +
                            " for it.",
                    5,
                    25,
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) }),
                PublicReviews(MainActivity
                    .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    "Emily " +
                            "Stephen",
                    "\"Just as Expected\"",
                    true,
                    "22-05-2022",
                    "I have oily skin. This primer covered my pores well and \n" +
                            "gave me a perfect base for my make-up. I had no breakouts using this product. Go" +
                            " for it.",
                    5,
                    0,
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) }),
                PublicReviews(MainActivity
                    .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    "Emily " +
                            "Stephen",
                    "\"Just as Expected\"",
                    true,
                    "22-05-2022",
                    "I have oily skin. This primer covered my pores well and \n" +
                            "gave me a perfect base for my make-up. I had no breakouts using this product. Go" +
                            " for it.",
                    5,
                    25,
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) }),
                PublicReviews(MainActivity
                    .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    "Emily " +
                            "Stephen",
                    "\"Just as Expected\"",
                    true,
                    "22-05-2022",
                    "I have oily skin. This primer covered my pores well and \n" +
                            "gave me a perfect base for my make-up. I had no breakouts using this product. Go" +
                            " for it.",
                    5,
                    25,
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) }),
                PublicReviews(MainActivity
                    .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    "Emily " +
                            "Stephen",
                    "\"Just as Expected\"",
                    true,
                    "22-05-2022",
                    "I have oily skin. This primer covered my pores well and \n" +
                            "gave me a perfect base for my make-up. I had no breakouts using this product. Go" +
                            " for it.",
                    5,
                    25,
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) },
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.joyride) }),
            )
        )
    }

    fun onClick(view: View) {


    }

}
