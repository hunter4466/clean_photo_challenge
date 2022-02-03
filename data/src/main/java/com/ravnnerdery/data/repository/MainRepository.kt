package com.ravnnerdery.data.repository

import androidx.lifecycle.LiveData
import com.ravnnerdery.data.database.models.PhotoInfo

interface MainRepository {
    fun allPhotosFromDatabase(): LiveData<List<PhotoInfo>>
    fun loadFromApiAndSetIntoDatabase()
}  