package com.leonardo.example.profile.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.leonardo.example.profile.databinding.ItemPhotoBinding
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto

class PhotosAdapter : ListAdapter<UnsplashPhoto, PhotosAdapter.PhotosViewHolder>(PhotosDiffCallback()) {

    class PhotosViewHolder private constructor(val binding: ItemPhotoBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}

class PhotosDiffCallback : DiffUtil.ItemCallback<UnsplashPhoto>() {
    override fun areItemsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItem: UnsplashPhoto, newItem: UnsplashPhoto): Boolean {
        TODO("Not yet implemented")
    }
}