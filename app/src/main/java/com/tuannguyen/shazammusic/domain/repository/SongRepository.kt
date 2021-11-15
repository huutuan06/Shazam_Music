package com.tuannguyen.shazammusic.domain.repository

import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.model.Song
import com.tuannguyen.shazammusic.data.util.Resource
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface SongRepository {
    suspend fun getRecommendedSongs(): Resource<APIResponse>
    suspend fun getSearchedSong(searchQuery: String): Resource<APIResponse>
    suspend fun saveSongToDB(song: Song)
    fun getSavedSongs(): Flow<List<Song>>
    suspend fun deleteSongFromDB(song: Song)
}