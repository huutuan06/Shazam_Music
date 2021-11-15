package com.tuannguyen.shazammusic.domain.usecase

import com.tuannguyen.shazammusic.data.model.Song
import com.tuannguyen.shazammusic.data.repository.DataSource.SongLocalRepository
import javax.inject.Inject

class DeleteSongFromDBUseCase @Inject constructor(
    private val songLocalRepository: SongLocalRepository
) {
    suspend fun execute(song: Song) {
        songLocalRepository.deleteSongFromDB(song)
    }
}