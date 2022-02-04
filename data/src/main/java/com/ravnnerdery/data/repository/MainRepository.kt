package com.ravnnerdery.data.repository

import androidx.lifecycle.LiveData
import com.ravnnerdery.domain.models.PhotoInfo

interface MainRepository {
    suspend fun allPhotosFromDatabase(): MutableList<PhotoInfo>
    fun loadFromApiAndSetIntoDatabase()
}  