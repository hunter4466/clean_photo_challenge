package com.ravnnerdery.data.repository

import androidx.lifecycle.LiveData
import com.ravnnerdery.data.database.models.PhotoInfoEntity

interface MainRepository {
    fun allPhotosFromDatabase(): LiveData<List<PhotoInfoEntity>>
    fun loadFromApiAndSetIntoDatabase()
}  