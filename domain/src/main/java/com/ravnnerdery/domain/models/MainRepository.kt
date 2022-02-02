package com.ravnnerdery.domain.models

import androidx.lifecycle.LiveData

interface MainRepository {
    fun allPhotosFromDatabase(): LiveData<List<PhotoInfo>>
    fun loadFromApiAndSetIntoDatabase()
}  