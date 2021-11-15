package com.tuannguyen.shazammusic.domain.usecase

import com.tuannguyen.shazammusic.data.model.APIResponse
import com.tuannguyen.shazammusic.data.util.Resource
import com.tuannguyen.shazammusic.domain.repository.SongRepository
import javax.inject.Inject

class GetSearchedSongUseCase @Inject constructor(
    private val songRepository: SongRepository
){
    suspend fun execute(searchQuery: String): Resource<APIResponse> {
        return songRepository.getSearchedSong(searchQuery)
    }
}