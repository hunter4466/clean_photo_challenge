package com.ravnnerdery.data.repository

import androidx.lifecycle.LiveData
import com.ravnnerdery.domain.models.MainRepository
import com.ravnnerdery.domain.models.PhotoInfo

class MainRepositoryImpl: MainRepository {
    override fun allPhotosFromDatabase(): LiveData<List<PhotoInfo>> {
        TODO("Not yet implemented")
    }

    override fun loadFromApiAndSetIntoDatabase() {
        TODO("Not yet implemented")
    }
}