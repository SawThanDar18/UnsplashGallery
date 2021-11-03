package com.sawthandar.unsplashsample.network

import com.sawthandar.unsplashsample.data.vos.PhotoVO
import com.sawthandar.unsplashsample.network.responses.GetSearchPhotosResponse
import com.sawthandar.unsplashsample.utils.GET_PHOTO_DETAIL
import com.sawthandar.unsplashsample.utils.GET_PHOTO_LIST
import com.sawthandar.unsplashsample.utils.GET_SEARCH_PHOTO
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PhotoApi {

    @GET(GET_PHOTO_LIST)
    fun getAllPhotos(): Call<List<PhotoVO>>

    @GET(GET_PHOTO_LIST)
    fun getAllPhotosObservable(): Observable<List<PhotoVO>>

    @GET(GET_PHOTO_DETAIL)
    fun getPhotoDetail(@Path("id") id: String): Call<PhotoVO>

    @GET(GET_SEARCH_PHOTO)
    fun getSearchPhoto(@Query("s") keyword: String): Call<GetSearchPhotosResponse>
}