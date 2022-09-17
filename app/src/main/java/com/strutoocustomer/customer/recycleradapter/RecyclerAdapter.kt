package com.strutoocustomer.customer.recycleradapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.SectionIndexer
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.strutoocustomer.BR
import com.strutoocustomer.R


class RecyclerAdapter<T : AbstractModel>(@LayoutRes val layoutId: Int) :
    RecyclerView.Adapter<RecyclerAdapter.VH<T>>(), SectionIndexer {
    private val animatedPosition: HashSet<Int> by lazy { HashSet() }
    val items by lazy { mutableListOf<T>() }
    private var inflater: LayoutInflater? = null
    private var onItemClick: OnItemClick? = null
    private var isAnimation = true
    private val mDataArray= ArrayList<String>()

    fun setAnimations(boolean: Boolean) {
        isAnimation = boolean
    }
    fun getAllItems() = items

    fun addItems(items: List<T>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun setOnItemClick(onItemClick: OnItemClick?) {
        this.onItemClick = onItemClick
    }


    fun insertAt(index: Int? = null, item: T) {
        items.add(index ?: items.size, item)
        notifyItemInserted(index ?: items.size - 1)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH<T> {
        val layoutInflater = inflater ?: LayoutInflater.from(parent.context)
        val binding =
            DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, layoutId, parent, false)
        return VH(binding)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: VH<T>, position: Int) {
//        holder.itemView.animation =
//            AnimationUtils.loadAnimation(holder.itemView.context, R.anim.item_anim)
        val model = items[position]
        model.adapterPosition = position
        onItemClick?.let { model.onItemClick = it }
        holder.bind(model)
        if (isAnimation)
            setAnimation(holder, position)
    }

    private fun setAnimation(holder: RecyclerView.ViewHolder, position: Int) {
        if (this.animatedPosition.contains(Integer.valueOf(position))) {
            holder.itemView.clearAnimation()
            return
        }
        holder.itemView.startAnimation(
            AnimationUtils.loadAnimation(
                holder.itemView.context,
                R.anim.anim_slide_from_bottom
            )
        )
        this.animatedPosition.add(Integer.valueOf(position))
    }


    class VH<T : AbstractModel>(private val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: T) {
            binding.setVariable(BR.model, model)
            binding.executePendingBindings()
        }
    }

    fun interface OnItemClick {
        fun onClick(view: View, position: Int, type: String)
    }

    override fun getSections(): Array<String> {
        val sections: MutableList<String> = ArrayList()
        for (data in 'A'..'Z') {
            mDataArray.add(data.toString())
            mDataArray.add(data.toString())
            mDataArray.add(data.toString())
            mDataArray.add(data.toString())
            mDataArray.add(data.toString())
        }

        for (data  in mDataArray.indices ){
            val section = mDataArray[data].uppercase()
            if (!sections.contains(section)) {
                sections.add(section)
            }
        }
        return sections.toTypedArray<String>()
    }

    override fun getPositionForSection(p0: Int): Int {
        return 0
    }

    override fun getSectionForPosition(p0: Int): Int {
        return 0
    }
}