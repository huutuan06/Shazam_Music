package com.tuannguyen.shazammusic.domain.usecase

import com.tuannguyen.shazammusic.data.model.Song
import com.tuannguyen.shazammusic.data.repository.DataSource.SongLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetSavedSongsUseCase @Inject constructor(
    private val songLocalRepository: SongLocalRepository
) {
    fun execute(): Flow<List<Song>> {
        return songLocalRepository.getSavedSongs()
    }
}