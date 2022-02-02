package com.ravnnerdery.cleanphotochallenge.viewModels

import androidx.lifecycle.ViewModel
import com.ravnnerdery.photo_challenge.repository.PhotosRepository

class EnlargedPhotoViewModel(private val repo : PhotosRepository) : ViewModel() {
    var currentPosition: Int? = 0
    fun allPhotos() = repo.allPhotosFromDatabase()
}