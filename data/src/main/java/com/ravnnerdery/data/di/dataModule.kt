package com.ravnnerdery.data.di

import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.database.PhotosDatabase
import com.ravnnerdery.data.repository.MainRepository
import com.ravnnerdery.data.repository.MainRepositoryImpl
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val dataModule = module {
    factory<MainRepository> {MainRepositoryImpl(get())}
    single { PhotosDatabase.buildDatabase(androidApplication())}
    factory {get<PhotosDatabase>().databaseDao()}
}