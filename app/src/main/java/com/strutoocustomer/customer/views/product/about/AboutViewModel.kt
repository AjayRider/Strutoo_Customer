package com.strutoocustomer.customer.views.product.about

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.models.OtherBranches
import com.strutoocustomer.customer.models.StaffsDetails
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AboutViewModel @Inject constructor() :ViewModel() {
    val staffAdapter = RecyclerAdapter<StaffsDetails>(R.layout.staffs_layout)
    val branchAdapter = RecyclerAdapter<OtherBranches>(R.layout.other_branch_layout)

    var isInfoSelected: ObservableField<Boolean> = ObservableField(false)
    var isOpeningTimeSelected: ObservableField<Boolean> = ObservableField(false)
    var isOurStaffSelected: ObservableField<Boolean> = ObservableField(false)
    var isContactUsSelected: ObservableField<Boolean> = ObservableField(false)
    var isAddressSelected: ObservableField<Boolean> = ObservableField(false)
    var isOtherBranchesSelected: ObservableField<Boolean> = ObservableField(false)

    init {
        staffAdapter.addItems(
            listOf(
                StaffsDetails(
                    MainActivity
                        .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.mask_group_8) },
                    "Rania"
                ),
                StaffsDetails(
                    MainActivity
                        .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.mask_group_8) },
                    "Nadia"
                ),
                StaffsDetails(
                    MainActivity
                        .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.mask_group_8) },
                    "Ramy"
                ),
                StaffsDetails(
                    MainActivity
                        .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.mask_group_8) },
                    "Rania"
                ),
                StaffsDetails(
                    MainActivity
                        .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.mask_group_8) },
                    "Nadia"
                ),
                StaffsDetails(
                    MainActivity
                        .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.mask_group_8) },
                    "Ramy"
                ),
            )
        )

        branchAdapter.addItems(
            listOf(
                OtherBranches("Other", "145 Stafford Rd, Wallington 13732,  Sector 14"),
                OtherBranches("Other", "145 Stafford Rd, Wallington 13732,  Sector 14"),
            )
        )
    }

    fun onClick(view: View) {
        when (view.id) {
            R.id.tvInfo -> {
                isInfoSelected.set(!(isInfoSelected.get() ?: false))
            }
            R.id.tvOpeningTime -> {
                isOpeningTimeSelected.set(!(isOpeningTimeSelected.get() ?: false))
            }
            R.id.tvOurStaff -> {
                isOurStaffSelected.set(!(isOurStaffSelected.get() ?: false))
            }
            R.id.tvContactUs -> {
                isContactUsSelected.set(!(isContactUsSelected.get() ?: false))
            }
            R.id.tvAddress -> {
                isAddressSelected.set(!(isAddressSelected.get() ?: false))
            }
            R.id.tvOtherBranch -> {
                isOtherBranchesSelected.set(!(isOtherBranchesSelected.get() ?: false))
            }

        }
    }
}
