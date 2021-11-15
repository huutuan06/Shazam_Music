package com.tuannguyen.shazammusic.domain.usecase

import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.domain.repository.SongRepository
import retrofit2.Response
import javax.inject.Inject

class GetSongsUseCase @Inject constructor(
    private val songRepository: SongRepository
){
    suspend fun execute(key: String, locale: String): Response<APIResponse> {
        return songRepository.getRecommendedSongs(key, locale)
    }
}
