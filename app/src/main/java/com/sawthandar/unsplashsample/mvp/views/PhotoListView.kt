package com.sawthandar.unsplashsample.mvp.views

import com.sawthandar.unsplashsample.data.vos.PhotoVO

interface PhotoListView: BaseView {

    fun displayPhotoList(photoList: List<PhotoVO>)
    fun displayError(errorMessage: String)
    fun navigateToDetail(photoId: String)
}