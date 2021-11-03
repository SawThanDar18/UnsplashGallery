package com.sawthandar.unsplashsample.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import com.sawthandar.unsplashsample.R
import com.sawthandar.unsplashsample.data.vos.PhotoVO
import com.sawthandar.unsplashsample.delegates.ItemClicked
import com.sawthandar.unsplashsample.viewHolders.PhotoItemViewHolder

class PhotoItemAdapter(private val delegate: ItemClicked): BaseAdapter<PhotoItemViewHolder, PhotoVO>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoItemViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.photo_item_view, parent, false)
        return PhotoItemViewHolder(layout, delegate)
    }
}