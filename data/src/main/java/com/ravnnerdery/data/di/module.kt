package com.ravnnerdery.data.di

import com.ravnnerdery.data.database.PhotosDatabase
import androidx.room.Room
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val DATAModule = module {
    single {
        Room.databaseBuilder(
            androidContext(),
            PhotosDatabase::class.java,
            "Photos_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }
}