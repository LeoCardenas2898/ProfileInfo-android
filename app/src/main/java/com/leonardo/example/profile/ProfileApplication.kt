package com.leonardo.example.profile

import android.app.Application
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker

class ProfileApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        UnsplashPhotoPicker.init(
            this,
            getString(R.string.access_key),
            getString(R.string.secret_key)
        ).setLoggingEnabled(true)
    }
}