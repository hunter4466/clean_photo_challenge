package com.ravnnerdery.domain.models

import androidx.lifecycle.LiveData

interface Repository {
    fun allPhotosFromDatabase(): LiveData<List<PhotoInfo>>
    fun loadFromApiAndSetIntoDatabase()
}