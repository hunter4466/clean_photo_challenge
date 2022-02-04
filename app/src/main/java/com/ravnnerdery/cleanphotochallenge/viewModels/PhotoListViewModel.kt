package com.ravnnerdery.cleanphotochallenge.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ravnnerdery.data.useCases.GetAllPhotosUseCase
import com.ravnnerdery.data.useCases.LoadApiToDbUseCase
import com.ravnnerdery.domain.models.PhotoInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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
    val mutableAllPhotos = MutableLiveData<List<PhotoInfo>>(emptyList())
    fun allPhotos(){
        viewModelScope.launch(Dispatchers.IO){
            mutableAllPhotos.postValue(getAllPhotos.execute())
        }
    }
    //getAllPhotos.execute()
}