package com.ravnnerdery.cleanphotochallenge.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebSettings
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.ravnnerdery.domain.models.PhotoInfo
import com.ravnnerdery.cleanphotochallenge.R
import com.ravnnerdery.cleanphotochallenge.databinding.PhotoViewReverseBinding
import com.ravnnerdery.cleanphotochallenge.databinding.PhotoViewStraightBinding

class PhotosAdapter(private val clickListener: PhotoClickListener) :
    ListAdapter<PhotoInfo, PhotosAdapter.ViewHolder>(PostListDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return if (viewType == 1) {
            SubViewHolderStraight.from(parent)
        } else {
            SubViewHolderReverse.from(parent)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position), clickListener)
    }

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.id.toInt() % 2 == 0) {
            1
        } else {
            0
        }
    }

    abstract class ViewHolder(val binding: ViewDataBinding) :
        RecyclerView.ViewHolder(binding.root) {
        abstract fun bind(item: PhotoInfo, clickListener: PhotoClickListener)
    }

    class SubViewHolderStraight private constructor(binding: PhotoViewStraightBinding) : ViewHolder(binding) {
        override fun bind(item: PhotoInfo, clickListener: PhotoClickListener) {
            val binding = binding as PhotoViewStraightBinding
            binding.photo = item
            binding.clickListener = clickListener
            val uri = GlideUrl(
                item.thumbnailUrl, LazyHeaders.Builder()
                    .addHeader(
                        "User-Agent",
                        WebSettings.getDefaultUserAgent(binding.thumbNailfromList.context)
                    )
                    .build()
            )
            Glide
                .with(binding.thumbNailfromList.context)
                .load(uri)
                .placeholder(R.drawable.background_img)
                .transition(DrawableTransitionOptions.withCrossFade(150))
                .into(binding.thumbNailfromList)

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PhotoViewStraightBinding.inflate(layoutInflater, parent, false)
                return SubViewHolderStraight(binding)
            }
        }
    }

    class SubViewHolderReverse private constructor(binding: PhotoViewReverseBinding) : ViewHolder(binding) {
        override fun bind(item: PhotoInfo, clickListener: PhotoClickListener) {
            val binding = binding as PhotoViewReverseBinding
            binding.photo = item
            binding.clickListener = clickListener
            val uri = GlideUrl(
                item.thumbnailUrl, LazyHeaders.Builder()
                    .addHeader(
                        "User-Agent",
                        WebSettings.getDefaultUserAgent(binding.thumbNailfromList.context)
                    )
                    .build()
            )
            Glide
                .with(binding.thumbNailfromList.context)
                .load(uri)
                .placeholder(R.drawable.background_img)
                .transition(DrawableTransitionOptions.withCrossFade(150))
                .into(binding.thumbNailfromList)

            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = PhotoViewReverseBinding.inflate(layoutInflater, parent, false)
                return SubViewHolderReverse(binding)
            }
        }

    }

}

class PostListDiffCallBack : DiffUtil.ItemCallback<PhotoInfo>() {
    override fun areItemsTheSame(oldItem: PhotoInfo, newItem: PhotoInfo): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PhotoInfo, newItem: PhotoInfo): Boolean {
        return oldItem.id == newItem.id
    }
}

class PhotoClickListener(val clickListener: (postId: Long) -> Unit) {
    fun onClick(photo: PhotoInfo) = clickListener(photo.id)
}