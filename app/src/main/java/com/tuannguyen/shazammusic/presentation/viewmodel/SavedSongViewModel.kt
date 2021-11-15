package com.tuannguyen.shazammusic.presentation.viewmodel

import androidx.lifecycle.liveData
import com.tuannguyen.shazammusic.domain.usecase.GetSavedSongsUseCase
import com.tuannguyen.shazammusic.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

@HiltViewModel
class SavedSongViewModel @Inject constructor(
    private val getSavedSongsUseCase: GetSavedSongsUseCase
): BaseViewModel() {

    fun getSavedSong() = liveData {
        getSavedSongsUseCase.execute().collect {
            emit(it)
        }
    }
}