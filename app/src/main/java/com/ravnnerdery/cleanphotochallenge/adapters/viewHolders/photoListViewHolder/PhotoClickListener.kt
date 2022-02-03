package com.ravnnerdery.cleanphotochallenge.adapters.viewHolders.photoListViewHolder

import com.ravnnerdery.data.database.models.PhotoInfo

class PhotoClickListener(val clickListener: (postId: Long) -> Unit) {
    fun onClick(photo: PhotoInfo) = clickListener(photo.id)
}