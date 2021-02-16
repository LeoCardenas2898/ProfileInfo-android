package com.leonardo.example.profile

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.shape.MaterialShapeDrawable
import com.leonardo.example.profile.databinding.ActivityProfileBinding
import com.leonardo.example.profile.util.BottomAppBarCutCornersTopEdge


class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupView()
    }

    private fun setupView() {
        with(binding) {
            bottomNavigationView.background = null
            bottomNavigationView.menu.getItem(2).isEnabled = false
            val topEdge = BottomAppBarCutCornersTopEdge(
                bottomAppBar.fabCradleMargin,
                bottomAppBar.fabCradleRoundedCornerRadius,
                bottomAppBar.cradleVerticalOffset
            )
            val background = bottomAppBar.background as MaterialShapeDrawable
            background.shapeAppearanceModel = background.shapeAppearanceModel.toBuilder().setTopEdge(topEdge).build()
        }
    }
}