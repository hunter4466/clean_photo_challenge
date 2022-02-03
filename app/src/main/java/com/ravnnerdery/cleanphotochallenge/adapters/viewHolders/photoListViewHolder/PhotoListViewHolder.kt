package com.ravnnerdery.cleanphotochallenge.adapters.viewHolders.photoListViewHolder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.ravnnerdery.data.database.models.PhotoInfo

abstract class PhotoListViewHolder(val binding: ViewDataBinding) :
    RecyclerView.ViewHolder(binding.root) {
    abstract fun bind(item: PhotoInfo, clickListener: PhotoClickListener)
}