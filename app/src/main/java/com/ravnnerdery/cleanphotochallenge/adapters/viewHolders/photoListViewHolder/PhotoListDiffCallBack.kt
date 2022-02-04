package com.ravnnerdery.cleanphotochallenge.adapters.viewHolders.photoListViewHolder

import androidx.recyclerview.widget.DiffUtil
import com.ravnnerdery.data.database.models.PhotoInfoEntity

class PostListDiffCallBack : DiffUtil.ItemCallback<PhotoInfoEntity>() {
    override fun areItemsTheSame(oldItem: PhotoInfoEntity, newItem: PhotoInfoEntity): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoInfoEntity, newItem: PhotoInfoEntity): Boolean {
        return oldItem.id == newItem.id
    }
}