package com.leonardo.example.profile.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.shape.MaterialShapeDrawable
import com.leonardo.example.profile.databinding.ActivityProfileBinding
import com.leonardo.example.profile.ui.adapter.PhotosAdapter
import com.leonardo.example.profile.util.BottomAppBarCutCornersTopEdge
import com.unsplash.pickerandroid.photopicker.data.UnsplashPhoto
import com.unsplash.pickerandroid.photopicker.presentation.UnsplashPickerActivity

class ProfileActivity : AppCompatActivity() {

    companion object {
        private const val REQUEST_CODE = 200
    }

    private lateinit var binding: ActivityProfileBinding
    private lateinit var photosAdapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        with(binding) {
            photosAdapter = PhotosAdapter()
            bottomNavigationView.run {
                background = null
                menu.getItem(2).isEnabled = false
            }
            contentProfile.photosRecyclerView.run {
                layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
                adapter = photosAdapter
            }
            val topEdge = BottomAppBarCutCornersTopEdge(
                bottomAppBar.fabCradleMargin,
                bottomAppBar.fabCradleRoundedCornerRadius,
                bottomAppBar.cradleVerticalOffset
            )
            fab.setOnClickListener {
                startActivityForResult(
                    UnsplashPickerActivity.getStartingIntent(
                        this@ProfileActivity, true
                    ), REQUEST_CODE
                )
            }
            (bottomAppBar.background as MaterialShapeDrawable).run {
                shapeAppearanceModel = shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == REQUEST_CODE) {
            photosAdapter.submitList(data?.getParcelableArrayListExtra(UnsplashPickerActivity.EXTRA_PHOTOS))
        }
    }
}