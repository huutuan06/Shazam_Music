package com.tuannguyen.shazammusic.data.repository

import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.repository.DataSource.SongRemoteRepository
import com.tuannguyen.shazammusic.domain.repository.SongRepository
import retrofit2.Response
import javax.inject.Inject

class SongRepositoryImpl @Inject constructor(
    private val songRemoteRepository: SongRemoteRepository
): SongRepository {
    override suspend fun getRecommendedSongs(key: String, locale: String): Response<APIResponse> {
        return songRemoteRepository.getRecommendedSongs(key, locale)
    }
}
