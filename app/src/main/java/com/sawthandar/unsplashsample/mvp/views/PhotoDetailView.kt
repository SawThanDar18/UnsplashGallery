package com.sawthandar.unsplashsample.mvp.views

import com.sawthandar.unsplashsample.data.vos.PhotoVO

interface PhotoDetailView: BaseView {
    fun displayPhotoDetail(photoVO: PhotoVO)
    fun errorMessage(errorMessage: String)
}