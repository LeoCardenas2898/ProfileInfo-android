package com.leonardo.example.profile.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leonardo.example.profile.databinding.ItemPhotoBinding
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto

class PhotosAdapter : ListAdapter<UnsplashPhoto, PhotosAdapter.PhotosViewHolder>(PhotosDiffCallback()) {

    class PhotosViewHolder private constructor(private val binding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(photo: UnsplashPhoto) {
            binding.imageView.setImageURI(photo.urls.small)
        }

        companion object {
            fun from(parent: ViewGroup): PhotosViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ItemPhotoBinding.inflate(layoutInflater, parent, false)
                return PhotosViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = PhotosViewHolder.from(parent)

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class PhotosDiffCallback : DiffUtil.ItemCallback<UnsplashPhoto>() {
    override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) = oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto) = oldItem == newItem
}