package com.tuannguyen.shazammusic.data.repository.DataSourceImpl

import com.tuannguyen.shazammusic.data.api.SongAPIService
import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.repository.DataSource.SongRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class SongRemoteRepositoryImpl @Inject constructor(
    private val songAPIService: SongAPIService
): SongRemoteRepository {
    override suspend fun getRecommendedSongs(): Response<APIResponse> {
        return songAPIService.getSongs()
    }

    override suspend fun getSearchedSongs(searchQuery: String): Response<APIResponse> {
        return songAPIService.getSearchedSongs(searchQuery)
    }
}
