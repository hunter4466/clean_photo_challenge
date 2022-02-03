package com.ravnnerdery.data.database

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ravnnerdery.data.database.models.PhotoInfo

@Database(entities = [PhotoInfo::class], version = 1, exportSchema = false)
abstract class PhotosDatabase: RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao
    companion object {
        fun buildDatabase(application: Application) {
            Room.databaseBuilder(
                application.applicationContext,
                PhotosDatabase::class.java,
                "Photos_database_clean"
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}