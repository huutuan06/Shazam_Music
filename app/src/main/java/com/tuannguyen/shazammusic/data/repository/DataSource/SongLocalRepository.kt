package com.tuannguyen.shazammusic.data.repository.DataSource

import com.tuannguyen.shazammusic.data.model.Song
import kotlinx.coroutines.flow.Flow

interface SongLocalRepository {
    suspend fun saveSongToDB(song: Song)
    fun getSavedSongs(): Flow<List<Song>>
    suspend fun deleteSongFromDB(song: Song)
}