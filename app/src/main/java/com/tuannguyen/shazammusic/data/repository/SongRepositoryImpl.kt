package com.tuannguyen.shazammusic.data.repository

import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.model.Song
import com.tuannguyen.shazammusic.data.repository.DataSource.SongLocalRepository
import com.tuannguyen.shazammusic.data.repository.DataSource.SongRemoteRepository
import com.tuannguyen.shazammusic.data.util.Resource
import com.tuannguyen.shazammusic.data.util.responseToResource
import com.tuannguyen.shazammusic.domain.repository.SongRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val songRemoteRepository: SongRemoteRepository,
    private val songLocalRepository: SongLocalRepository
): SongRepository {
    override suspend fun getRecommendedSongs(): Resource<APIResponse> {
        return responseToResource(songRemoteRepository.getRecommendedSongs())
    }

    override suspend fun getSearchedSong(searchQuery: String): Resource<APIResponse> {
        return responseToResource(songRemoteRepository.getSearchedSongs(searchQuery))
    }

    override suspend fun saveSongToDB(song: Song) {
        songLocalRepository.saveSongToDB(song)
    }

    override fun getSavedSongs(): Flow<List<Song>> {
        return songLocalRepository.getSavedSongs()
    }

    override suspend fun deleteSongFromDB(song: Song) {
        songLocalRepository.deleteSongFromDB(song)
    }
}
