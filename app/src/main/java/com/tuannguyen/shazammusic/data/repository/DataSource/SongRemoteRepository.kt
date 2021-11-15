package com.tuannguyen.shazammusic.data.repository.DataSource

import com.tuannguyen.shazammusic.data.model.APIResponse
import retrofit2.Response

interface SongRemoteRepository {

    suspend fun getRecommendedSongs(): Response<APIResponse>
    suspend fun getSearchedSongs(searchQuery: String): Response<APIResponse>
}