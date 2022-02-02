package com.ravnnerdery.cleanphotochallenge.viewModels

import androidx.lifecycle.ViewModel
import com.ravnnerdery.domain.models.MainRepository

class EnlargedPhotoViewModel(private val repo : MainRepository) : ViewModel() {
    var currentPosition: Int? = 0
    fun allPhotos() = repo.allPhotosFromDatabase()
}