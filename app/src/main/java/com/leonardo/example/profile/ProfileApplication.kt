package com.leonardo.example.profile

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco
import com.unsplash.pickerandroid.photopicker.UnsplashPhotoPicker

class ProfileApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
        UnsplashPhotoPicker.init(this, getString(R.string.access_key), getString(R.string.secret_key))
            .setLoggingEnabled(true)
    }
}