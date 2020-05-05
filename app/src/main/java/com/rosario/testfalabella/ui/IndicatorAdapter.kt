package com.rosario.testfalabella.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.rosario.testfalabella.R
import com.rosario.testfalabella.data.model.Indicator
import com.rosario.testfalabella.databinding.ItemIndicatorBinding
import com.rosario.testfalabella.viewModel.ItemViewModel

class IndicatorAdapter : RecyclerView.Adapter<IndicatorAdapter.IndicatorViewHolder>() {

    private lateinit var indicatorList: ArrayList<Indicator>

    inner class IndicatorViewHolder(val binding: ItemIndicatorBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(indicator: Indicator) {
            binding.viewModel = ItemViewModel(indicator)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): IndicatorViewHolder {
        val binding: ItemIndicatorBinding =
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_indicator,
                parent,
                false
            )
        return IndicatorViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return if (::indicatorList.isInitialized) indicatorList.size else 0
    }

    override fun onBindViewHolder(holder: IndicatorViewHolder, position: Int) {
        holder.bind(indicatorList[position])
    }

    fun updateList(listIndicator: ArrayList<Indicator>)
    {
        this.indicatorList = listIndicator
        notifyDataSetChanged()

    }
}