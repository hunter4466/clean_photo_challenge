package com.ravnnerdery.cleanphotochallenge.adapters.viewHolders.photoListViewHolder

import com.ravnnerdery.data.database.models.PhotoInfoEntity

class PhotoClickListener(val clickListener: (postId: Long) -> Unit) {
    fun onClick(photoEntity: PhotoInfoEntity) = clickListener(photoEntity.id)
}