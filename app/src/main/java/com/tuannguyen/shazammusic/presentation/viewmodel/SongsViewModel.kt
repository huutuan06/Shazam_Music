package com.tuannguyen.shazammusic.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.util.Resource
import com.tuannguyen.shazammusic.domain.usecase.GetSearchedSongUseCase
import com.tuannguyen.shazammusic.domain.usecase.GetSongsUseCase
import com.tuannguyen.shazammusic.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongsViewModel @Inject constructor(
    private val getSongsUseCase: GetSongsUseCase,
    private val getSearchedSongUseCase: GetSearchedSongUseCase
): BaseViewModel() {
    val songs = MutableLiveData<Resource<APIResponse>>()
    val searchedSongs: MutableLiveData<Resource<APIResponse>> = MutableLiveData()

    fun getSongs() = viewModelScope.launch(Dispatchers.IO) {
        songs.postValue(Resource.Loading())
        try {
            val apiResult = getSongsUseCase.execute()
            songs.postValue(apiResult)
        } catch (e: Exception) {
            songs.postValue(Resource.Error(e.message.toString()))
            Log.e("SongsViewModel:",e.message.toString())
        }
    }

    fun searchSong(searchQuery: String) = viewModelScope.launch(Dispatchers.IO) {
        searchedSongs.postValue(Resource.Loading())
        try {
            val searchResult = getSearchedSongUseCase.execute(searchQuery)
            searchedSongs.postValue(searchResult)
        } catch (e: Exception) {
            searchedSongs.postValue(Resource.Error(e.message.toString()))
            Log.e("SongsViewModel:", e.message.toString())
        }
    }
}
