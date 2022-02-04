package com.ravnnerdery.cleanphotochallenge.viewModels

import androidx.lifecycle.ViewModel
import com.ravnnerdery.data.useCases.GetAllPhotosUseCase

class EnlargedPhotoViewModel(private val getAllPhotos : GetAllPhotosUseCase) : ViewModel() {
    var currentPosition: Int? = 0
    fun allPhotos() = getAllPhotos.execute()
}