package com.sawthandar.unsplashsample.mvp.presenters

import com.sawthandar.unsplashsample.activities.BaseAcitvity
import com.sawthandar.unsplashsample.data.models.PhotoListModelImpl
import com.sawthandar.unsplashsample.mvp.views.PhotoDetailView

class PhotoDetailPresenter: BasePresenter<PhotoDetailView>() {

    fun onUiReady(activity: BaseAcitvity, photoId: String) {
        if (photoId != null) {
            val model = PhotoListModelImpl
            model.getPhotoDetail(photoId, {
                mView.displayPhotoDetail(it)
            }, {
                mView.errorMessage(it)
            })
        }
    }
}