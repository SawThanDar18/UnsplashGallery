package com.sawthandar.unsplashsample.network.responses

import com.google.gson.annotations.SerializedName
import com.sawthandar.unsplashsample.data.vos.PhotoVO

data class GetSearchPhotosResponse(

        @SerializedName("results")
        var results: List<PhotoVO>
)