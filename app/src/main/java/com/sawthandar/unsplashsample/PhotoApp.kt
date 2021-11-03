package com.sawthandar.unsplashsample

import android.app.Application
import com.sawthandar.unsplashsample.data.models.PhotoListModelImpl

class PhotoApp: Application(){

    override fun onCreate() {
        super.onCreate()
        PhotoListModelImpl.initDatabase(applicationContext)
    }
}