package com.sawthandar.unsplashsample.data.models

import androidx.lifecycle.LiveData
import com.sawthandar.unsplashsample.data.vos.PhotoVO

interface PhotoListModel {

    fun getAllPhotos(
        onFailure: (String) -> Unit
    ) : LiveData<List<PhotoVO>>

    fun getPhotoDetail(
        id: String,
        onSuccess: (PhotoVO) -> Unit,
        onFailure: (String) -> Unit
    )

    fun getSearchPhoto(searchValue: String): List<PhotoVO>
}