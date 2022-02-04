package com.ravnnerdery.cleanphotochallenge.adapters

import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.ravnnerdery.cleanphotochallenge.adapters.viewHolders.enlargedPhotoViewHolder.EnlargedPhotoDiffCallBack
import com.ravnnerdery.cleanphotochallenge.adapters.viewHolders.enlargedPhotoViewHolder.EnlargedPhotoViewHolder
import com.ravnnerdery.data.database.models.PhotoInfoEntity

class EnlargedPhotoAdapter :
    ListAdapter<PhotoInfoEntity, EnlargedPhotoViewHolder>(EnlargedPhotoDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnlargedPhotoViewHolder {
        return EnlargedPhotoViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: EnlargedPhotoViewHolder, position: Int) {
        val item = getItem(position)
            holder.bind(item)
    }

}


