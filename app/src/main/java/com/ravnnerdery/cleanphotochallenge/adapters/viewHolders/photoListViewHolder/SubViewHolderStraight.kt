package com.ravnnerdery.cleanphotochallenge.adapters.viewHolders.photoListViewHolder

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ravnnerdery.cleanphotochallenge.databinding.PhotoViewStraightBinding
import com.ravnnerdery.cleanphotochallenge.utils.glidify
import com.ravnnerdery.data.database.models.PhotoInfoEntity

class SubViewHolderStraight private constructor(binding: PhotoViewStraightBinding) :
    PhotoListViewHolder(binding) {

    override fun bind(item: PhotoInfoEntity, clickListener: PhotoClickListener) {
        val binding = binding as PhotoViewStraightBinding
        binding.photo = item
        binding.clickListener = clickListener
        glidify(item.thumbnailUrl, binding.thumbNailfromList)
        binding.executePendingBindings()
    }

    companion object {
        fun from(parent: ViewGroup): PhotoListViewHolder {
            val layoutInflater = LayoutInflater.from(parent.context)
            val binding = PhotoViewStraightBinding.inflate(layoutInflater, parent, false)
            return SubViewHolderStraight(binding)
        }
    }
}