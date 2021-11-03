package com.sawthandar.unsplashsample.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sawthandar.unsplashsample.data.models.PhotoListModel
import com.sawthandar.unsplashsample.data.models.PhotoListModelImpl

abstract class BaseAcitvity: AppCompatActivity() {

    protected lateinit var model: PhotoListModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        model = PhotoListModelImpl
    }
}