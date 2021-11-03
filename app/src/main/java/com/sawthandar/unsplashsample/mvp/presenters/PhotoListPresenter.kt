package com.sawthandar.unsplashsample.mvp.presenters

import androidx.lifecycle.Observer
import com.sawthandar.unsplashsample.activities.BaseAcitvity
import com.sawthandar.unsplashsample.data.models.PhotoListModelImpl
import com.sawthandar.unsplashsample.delegates.ItemClicked
import com.sawthandar.unsplashsample.mvp.views.PhotoListView

class PhotoListPresenter: BasePresenter<PhotoListView>(), ItemClicked {

    override fun onItemClicked(id: String) {
        mView.navigateToDetail(id)
    }

    fun onUiReady(activity: BaseAcitvity){
        val model = PhotoListModelImpl
        model.getAllPhotos { mView.displayError(it) }
            .observe(activity, Observer {
                mView.displayPhotoList(it)
            })
    }

    /*fun displaySearchPhotos(searchValue: String){
        val model = PhotoListModelImpl
        model.getSearchPhoto(searchValue)
    }*/
}