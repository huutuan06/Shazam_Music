package com.tuannguyen.shazammusic.presentation.viewmodel

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.tuannguyen.shazammusic.data.model.Song
import com.tuannguyen.shazammusic.domain.usecase.DeleteSongFromDBUseCase
import com.tuannguyen.shazammusic.domain.usecase.GetSavedSongsUseCase
import com.tuannguyen.shazammusic.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedSongViewModel @Inject constructor(
    private val getSavedSongsUseCase: GetSavedSongsUseCase,
    private val deleteSongFromDBUseCase: DeleteSongFromDBUseCase
): BaseViewModel() {

    fun getSavedSong() = liveData {
        getSavedSongsUseCase.execute().collect {
            emit(it)
        }
    }

    fun deleteSong(song: Song) = viewModelScope.launch(Dispatchers.IO) {
        deleteSongFromDBUseCase.execute(song)
    }
}
