package com.ravnnerdery.data.repository

import androidx.lifecycle.LiveData
import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.networking.PhotosApi
import com.ravnnerdery.data.database.models.PhotoInfo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainRepositoryImpl(private val photosDao: DatabaseDao): MainRepository {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    override fun allPhotosFromDatabase(): LiveData<List<PhotoInfo>> = photosDao.getPhotos()

    override fun loadFromApiAndSetIntoDatabase() {
        PhotosApi.retrofitService.getPhotos().enqueue(object : Callback<List<PhotoInfo>> {
            override fun onResponse(call: Call<List<PhotoInfo>>, response: Response<List<PhotoInfo>>) {
                response.body()?.forEach { elm ->
                    addPostToDatabase(elm.id, elm.title, elm.url, elm.thumbnailUrl)
                }
            }

            override fun onFailure(call: Call<List<PhotoInfo>>, t: Throwable) {
                println(t.message)
            }
        })
    }
    private fun addPostToDatabase(id: Long, title: String, url: String, thumbUrl: String) {
        uiScope.launch(Dispatchers.IO) {
            val newPhoto = PhotoInfo(id, title, url, thumbUrl)
            photosDao.insertPhoto(newPhoto)
        }
    }
}