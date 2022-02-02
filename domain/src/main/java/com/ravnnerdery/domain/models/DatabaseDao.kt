package com.ravnnerdery.domain.models

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface DatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPhoto(photo: PhotoInfo)

    @Query("SELECT * from photo_table LIMIT 100")
    fun getPhotos(): LiveData<List<PhotoInfo>>

}
