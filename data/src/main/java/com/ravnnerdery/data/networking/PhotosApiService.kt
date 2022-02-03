package com.ravnnerdery.domain.models

import com.ravnnerdery.data.database.models.PhotoInfo
import retrofit2.Call
import retrofit2.http.GET

interface PostsApiService {
    @GET("photos")
    fun getPhotos(): Call<List<PhotoInfo>>
}