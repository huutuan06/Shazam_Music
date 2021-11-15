package com.tuannguyen.shazammusic.data.repository

import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.repository.DataSource.SongRemoteRepository
import com.tuannguyen.shazammusic.data.util.Resource
import com.tuannguyen.shazammusic.data.util.responseToResource
import com.tuannguyen.shazammusic.domain.repository.SongRepository
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val songRemoteRepository: SongRemoteRepository
): SongRepository {
    override suspend fun getRecommendedSongs(): Resource<APIResponse> {
        return responseToResource(songRemoteRepository.getRecommendedSongs())
    }

    override suspend fun getSearchedSong(searchQuery: String): Resource<APIResponse> {
        return responseToResource(songRemoteRepository.getSearchedSongs(searchQuery))
    }
}
