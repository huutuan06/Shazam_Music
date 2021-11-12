package com.tuannguyen.shazammusic.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.repository.DataSource.SongRemoteRepository
import com.tuannguyen.shazammusic.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class SongsViewModel @Inject constructor(
    private val remoteRepository: SongRemoteRepository
): BaseViewModel() {
    var recommendedSongs = MutableLiveData<Response<APIResponse>>()

    fun getRecommendedSongs(key: String, locale: String) = viewModelScope.launch(Dispatchers.IO) {
        try {
            val apiResult = remoteRepository.getRecommendedSongs(key, locale)
            recommendedSongs.postValue(apiResult)
        } catch (e: Exception) {
            Log.e("SongsViewModel Error!",e.message.toString())
        }
    }
}