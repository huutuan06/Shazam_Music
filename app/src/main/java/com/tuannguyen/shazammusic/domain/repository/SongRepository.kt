package com.tuannguyen.shazammusic.domain.repository

import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.util.Resource
import retrofit2.Response

interface SongRepository {
    suspend fun getRecommendedSongs(): Resource<APIResponse>
    suspend fun getSearchedSong(searchQuery: String): Resource<APIResponse>
}