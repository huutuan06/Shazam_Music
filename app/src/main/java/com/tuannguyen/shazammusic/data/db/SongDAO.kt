package com.tuannguyen.shazammusic.data.db

import androidx.room.*
import com.tuannguyen.shazammusic.data.model.Song
import kotlinx.coroutines.flow.Flow

@Dao
interface SongDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(song: Song)

    @Query("SELECT * FROM songs")
    fun getAllSongs(): Flow<List<Song>>

    @Delete
    suspend fun deleteSong(song: Song)
}
