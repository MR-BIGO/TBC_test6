package com.example.tbc_test6.presentation.passcode.rv_adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tbc_test6.data.common.InputButton
import com.example.tbc_test6.databinding.InputButtonLayoutBinding
import com.example.tbc_test6.databinding.InputImageButtonLayoutBinding

class InputsRecyclerAdapter :
    ListAdapter<InputButton, RecyclerView.ViewHolder>(ItemDiffUtil()) {

    var itemOnClick: ((Int) -> Unit)? = null

    companion object {
        const val BUTTON = 1
        const val IMAGEBUTTON = 2
    }

    inner class InputsRecyclerButtonViewHolder(val binding: InputButtonLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {


        init {
            binding.btnInput.setOnClickListener {
                itemOnClick?.invoke(adapterPosition)
            }
        }

        fun bind() {
            val input = currentList[adapterPosition]
            with(binding) {

                btnInput.text = input.symbol


            }
        }
    }

    inner class InputsRecyclerImageViewHolder(val binding: InputImageButtonLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            val input = currentList[adapterPosition]
            with(binding) {
                input.icon?.let { btnImage.setImageResource(it) }

            }
        }
    }

    class ItemDiffUtil : DiffUtil.ItemCallback<InputButton>() {
        override fun areItemsTheSame(oldItem: InputButton, newItem: InputButton): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: InputButton, newItem: InputButton): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == BUTTON) {
            InputsRecyclerButtonViewHolder(
                InputButtonLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            InputsRecyclerImageViewHolder(
                InputImageButtonLayoutBinding.inflate(
                    LayoutInflater.from(
                        parent.context
                    ), parent, false
                )
            )
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is InputsRecyclerButtonViewHolder) {
            holder.bind()
        } else if (holder is InputsRecyclerImageViewHolder) {
            holder.bind()
        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (currentList[position].symbol.isNullOrEmpty()) {
            IMAGEBUTTON
        } else {
            BUTTON
        }
    }
}