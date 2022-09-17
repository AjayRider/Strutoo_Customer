package com.strutoocustomer.customer.views.product.services

import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.strutoocustomer.MainActivity
import com.strutoocustomer.R
import com.strutoocustomer.customer.models.ServicesDetails
import com.strutoocustomer.customer.models.ServicesTypes
import com.strutoocustomer.customer.models.TypesOfHairCuts
import com.strutoocustomer.customer.recycleradapter.DummyModel
import com.strutoocustomer.customer.recycleradapter.RecyclerAdapter
import com.strutoocustomer.databinding.BottomSheetScheduleBinding
import com.strutoocustomer.utils.navigateBack
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class ServicesViewModel @Inject constructor() : ViewModel() {
    val servicesAdapter = RecyclerAdapter<ServicesDetails>(R.layout.services_layout)
    val servicesTypes = RecyclerAdapter<ServicesTypes>(R.layout.services_types_layout)
    var personType =  RecyclerAdapter<DummyModel>(R.layout.item_inner_bottom_schedule)
    var timeAdapter = RecyclerAdapter<DummyModel>(R.layout.bottomsheet_singleitem)
    var dateAdapter = RecyclerAdapter<DummyModel>(R.layout.item_layout_day_singleitem)


    init {
        servicesTypes.addItems(
            listOf(
                ServicesTypes("Women’s haircut"),
                ServicesTypes("Hair colouring"),
                ServicesTypes("Hair highlights"),
                ServicesTypes("Hair strengthening"),
                ServicesTypes("Hair styling"),
                ServicesTypes("Permanent curls"),
            )
        )

        servicesTypes.items.map {
            it.hairCutAdapter.items.map { data ->
                data.childAdapter.addItems(
                    listOf(
                        DummyModel(),
                        DummyModel(), DummyModel
                            (), DummyModel
                            (), DummyModel
                            ()
                    )
                )

                setOnChildClickListner(data.childAdapter)
            }

            setOnClickListner(it.hairCutAdapter)
        }
        servicesAdapter.addItems(
            listOf(
                ServicesDetails(
                    MainActivity
                        .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.ic_makeup) },
                    "MAKEUP"
                ),
                ServicesDetails(
                    MainActivity
                        .context.get()?.let { ContextCompat.getDrawable(it, R.drawable.ic_hair) },
                    "HAIR"
                ),
                ServicesDetails(
                    MainActivity
                        .context.get()
                        ?.let { ContextCompat.getDrawable(it, R.drawable.ic_hair_care) },
                    "BARBER SHOP"
                ),
            )
        )

        servicesTypes.setOnItemClick { view, position, _ ->
            val item = servicesTypes.getAllItems()[position]
            when (view.id) {
                R.id.llWomenHairCut -> {
                    if (position == 0) {
                        item.isSelected = !item.isSelected
                        servicesTypes.notifyItemChanged(position, item)
                    }
                }
            }
        }
    }

    fun setOnClickListner(childAdapter: RecyclerAdapter<TypesOfHairCuts>) {

        val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
            when (view.id) {
                R.id.clWomenHAirCut -> {
                    MainActivity.onItemClick?.onPerformClick()
                    childAdapter.items[position].isSelected = true
                    childAdapter.notifyDataSetChanged()
                }
            }
        }
        childAdapter.setOnItemClick(adapterClick)
    }

    fun setOnChildClickListner(childAdapter: RecyclerAdapter<DummyModel>) {

        val adapterClick = RecyclerAdapter.OnItemClick { view, position, type ->
            when (view.id) {
                R.id.layoutProvider -> {
                    openBottomSheet()
                }
            }
        }
        childAdapter.setOnItemClick(adapterClick)
    }

    private fun openBottomSheet() {

        val bottomSheet =
            BottomSheetDialog(MainActivity.context.get()!!, R.style.CustomBottomSheetDialogTheme)
        val scheduleBinding =
            BottomSheetScheduleBinding.inflate(LayoutInflater.from(MainActivity.context.get()))

        dateAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(), DummyModel
                    (), DummyModel
                    ()
            )
        )

        timeAdapter.addItems(
            listOf(
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
                DummyModel(),
            )
        )

        personType.addItems(
            listOf(
                DummyModel(name = "Person 1"),
                DummyModel(name = "Person 2"),
                DummyModel(name = "Person 3"),
                DummyModel(name = "Person 4"),
                DummyModel(name = "Person 5"),

        ))


        scheduleBinding.rvPerson.adapter = personType
        scheduleBinding.rvDay.adapter = dateAdapter
        scheduleBinding.rvAtWhatTime.adapter = timeAdapter


        scheduleBinding.btnContinue.setOnClickListener {
            bottomSheet.dismiss()
        }

        scheduleBinding.ivClose.setOnClickListener {
            bottomSheet.dismiss()
        }

        bottomSheet.setContentView(scheduleBinding.root)
        bottomSheet.show()
    }

    fun onClick(view: View) {
        when (view.id) {

        }
    }
}
