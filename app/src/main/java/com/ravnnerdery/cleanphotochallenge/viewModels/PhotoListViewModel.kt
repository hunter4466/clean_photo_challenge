package com.ravnnerdery.cleanphotochallenge.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravnnerdery.data.repository.MainRepository

class PhotoListViewModel(private val repo : MainRepository) : ViewModel() {

    private val _navigateToSnapshot = MutableLiveData<Long?>()
    var currentPosition: Int? = 0

    val navigateToSnapshot
        get() = _navigateToSnapshot

    fun startRefreshingData(){
        repo.loadFromApiAndSetIntoDatabase()
    }

    fun onPhotoClicked(id: Long){
        _navigateToSnapshot.value = id
    }

    fun onSnapshotNavigated() {
        _navigateToSnapshot.value = null
    }

    fun allPhotos() = repo.allPhotosFromDatabase()
}