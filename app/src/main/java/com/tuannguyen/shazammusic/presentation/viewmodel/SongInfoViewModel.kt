package com.tuannguyen.shazammusic.presentation.viewmodel

import androidx.lifecycle.viewModelScope
import com.tuannguyen.shazammusic.data.model.Song
import com.tuannguyen.shazammusic.domain.usecase.SaveSongToDBUseCase
import com.tuannguyen.shazammusic.presentation.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SongInfoViewModel @Inject constructor(
    private val saveSongToDBUseCase: SaveSongToDBUseCase
): BaseViewModel() {

    fun saveSongToDB(song: Song) = viewModelScope.launch(Dispatchers.IO) {
        saveSongToDBUseCase.execute(song)
    }
}
