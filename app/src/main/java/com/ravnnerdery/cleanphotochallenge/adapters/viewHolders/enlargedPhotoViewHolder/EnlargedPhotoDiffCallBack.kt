package com.ravnnerdery.cleanphotochallenge.adapters.viewHolders.enlargedPhotoViewHolder

import androidx.recyclerview.widget.DiffUtil
import com.ravnnerdery.data.database.models.PhotoInfo

class EnlargedPhotoDiffCallBack : DiffUtil.ItemCallback<PhotoInfo>() {
    override fun areItemsTheSame(oldItem: PhotoInfo, newItem: PhotoInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoInfo, newItem: PhotoInfo): Boolean {
        return oldItem.id == newItem.id
    }
}