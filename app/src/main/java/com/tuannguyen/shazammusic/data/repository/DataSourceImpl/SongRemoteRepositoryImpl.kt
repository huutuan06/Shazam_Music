package com.tuannguyen.shazammusic.data.repository.DataSourceImpl

import com.tuannguyen.shazammusic.data.api.SongAPIService
import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.repository.DataSource.SongRemoteRepository
import retrofit2.Response
import javax.inject.Inject

class SongRemoteRepositoryImpl @Inject constructor(
    private val songAPIService: SongAPIService
): SongRemoteRepository {
    override suspend fun getRecommendedSongs(key: String, locale: String): Response<APIResponse> {
        return songAPIService.getRecommendedSong(key, locale)
    }
}
