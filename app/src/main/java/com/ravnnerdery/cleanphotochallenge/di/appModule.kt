package com.ravnnerdery.cleanphotochallenge.di

import com.ravnnerdery.cleanphotochallenge.viewModels.EnlargedPhotoViewModel
import com.ravnnerdery.cleanphotochallenge.viewModels.PhotoListViewModel
import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.database.PhotosDatabase
import com.ravnnerdery.data.repository.MainRepository
import com.ravnnerdery.data.repository.MainRepositoryImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PhotoListViewModel(get()) }
    viewModel { EnlargedPhotoViewModel(get()) }
}
