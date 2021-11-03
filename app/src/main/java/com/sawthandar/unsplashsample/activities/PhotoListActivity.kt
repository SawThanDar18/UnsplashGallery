package com.sawthandar.unsplashsample.activities

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.KeyEvent
import android.view.WindowManager
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.sawthandar.unsplashsample.R
import com.sawthandar.unsplashsample.adapters.PhotoItemAdapter
import com.sawthandar.unsplashsample.data.vos.PhotoVO
import com.sawthandar.unsplashsample.mvp.presenters.PhotoListPresenter
import com.sawthandar.unsplashsample.mvp.views.PhotoListView
import kotlinx.android.synthetic.main.activity_photo_list.*

class PhotoListActivity : BaseAcitvity(), PhotoListView {

    override fun displayPhotoList(photoList: List<PhotoVO>) {
        photoItemAdapter.setNewData(photoList.toMutableList())
    }

    override fun displayError(errorMessage: String) {
        Snackbar.make(rootView, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    override fun navigateToDetail(photoId: String) {
        startActivity(PhotoDetailActivity.newIntent(applicationContext, photoId))
    }

    private lateinit var photoItemAdapter: PhotoItemAdapter
    private lateinit var photoListPresenter: PhotoListPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_photo_list)

        photoListPresenter = ViewModelProviders.of(this).get(PhotoListPresenter::class.java)
        photoListPresenter.initPresenter(this)

        photoItemAdapter = PhotoItemAdapter(photoListPresenter)
        rv_photos.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        rv_photos.setHasFixedSize(true)
        rv_photos.adapter = photoItemAdapter

        photoListPresenter.onUiReady(this)
    }

    fun searchByKeyword(keyword: String){
        photoItemAdapter.setNewData(model.getSearchPhoto(keyword) as MutableList<PhotoVO>)
        rv_photos.adapter = photoItemAdapter

    }

}
