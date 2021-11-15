package com.tuannguyen.shazammusic.data.repository.DataSourceImpl

import com.tuannguyen.shazammusic.data.db.SongDAO
import com.tuannguyen.shazammusic.data.model.Song
import com.tuannguyen.shazammusic.data.repository.DataSource.SongLocalRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SongLocalRepositoryImpl @Inject constructor(
    private val songDAO: SongDAO
): SongLocalRepository {
    override suspend fun saveSongToDB(song: Song) {
        songDAO.insert(song)
    }

    override fun getSavedSongs(): Flow<List<Song>> {
        return songDAO.getAllSongs()
    }

    override suspend fun deleteSongFromDB(song: Song) {
        return songDAO.deleteSong(song)
    }
}
