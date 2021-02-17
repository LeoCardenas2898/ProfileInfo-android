package com.leonardo.example.profile.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.shape.MaterialShapeDrawable
import com.leonardo.example.profile.databinding.ActivityProfileBinding
import com.leonardo.example.profile.ui.adapter.PhotosAdapter
import com.leonardo.example.profile.util.BottomAppBarCutCornersTopEdge

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private lateinit var adapter: PhotosAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        with(binding) {
            bottomNavigationView.run {
                background = null
                menu.getItem(2).isEnabled = false
            }
            contentProfile.photosRecyclerView.run {

            }
            val topEdge = BottomAppBarCutCornersTopEdge(
                bottomAppBar.fabCradleMargin,
                bottomAppBar.fabCradleRoundedCornerRadius,
                bottomAppBar.cradleVerticalOffset
            )
            (bottomAppBar.background as MaterialShapeDrawable).run {
                shapeAppearanceModel = shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()
            }
        }
    }
}