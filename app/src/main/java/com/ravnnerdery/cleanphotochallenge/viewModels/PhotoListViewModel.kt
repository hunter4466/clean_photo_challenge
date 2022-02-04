package com.ravnnerdery.cleanphotochallenge.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ravnnerdery.data.repository.MainRepository
import com.ravnnerdery.data.useCases.GetAllPhotosUseCase
import com.ravnnerdery.data.useCases.LoadApiToDbUseCase

class PhotoListViewModel(
    private val getAllPhotos : GetAllPhotosUseCase,
    private val loadApiToDb : LoadApiToDbUseCase
    ) : ViewModel() {

    private val _navigateToSnapshot = MutableLiveData<Long?>()
    var currentPosition: Int? = 0

    val navigateToSnapshot
        get() = _navigateToSnapshot

    fun startRefreshingData(){
        loadApiToDb.execute()
    }

    fun onPhotoClicked(id: Long){
        _navigateToSnapshot.value = id
    }

    fun onSnapshotNavigated() {
        _navigateToSnapshot.value = null
    }

    fun allPhotos() = getAllPhotos.execute()
}