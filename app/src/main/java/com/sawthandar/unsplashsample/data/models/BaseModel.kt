package com.sawthandar.unsplashsample.data.models

import android.content.Context
import com.sawthandar.unsplashsample.network.dataagents.PhotoDataAgent
import com.sawthandar.unsplashsample.network.dataagents.RetrofitDataAgent
import com.sawthandar.unsplashsample.persistance.PhotoDatabase

abstract class BaseModel{

    protected val dataAgent: PhotoDataAgent = RetrofitDataAgent

    protected lateinit var database: PhotoDatabase

    fun initDatabase(context: Context){
        database = PhotoDatabase.getInstance(context)
    }
}