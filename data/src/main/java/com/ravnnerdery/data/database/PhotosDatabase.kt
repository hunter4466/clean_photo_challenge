package com.ravnnerdery.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ravnnerdery.domain.models.DatabaseDao
import com.ravnnerdery.domain.models.PhotoInfo

@Database(entities = [PhotoInfo::class], version = 1, exportSchema = false)
abstract class PhotosDatabase: RoomDatabase() {
    abstract val databaseDao: DatabaseDao
}