package com.tuannguyen.shazammusic.domain.repository

import com.tuannguyen.shazammusic.data.model.APIResponse
import retrofit2.Response

interface SongRepository {
    suspend fun getRecommendedSongs(key: String, locale: String): Response<APIResponse>
}