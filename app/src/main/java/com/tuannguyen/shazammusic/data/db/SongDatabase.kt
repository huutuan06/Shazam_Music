package com.tuannguyen.shazammusic.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.tuannguyen.shazammusic.data.model.Song

@Database(
    entities = [Song::class],
    version = 1,
    exportSchema = false
)
abstract class SongDatabase : RoomDatabase() {
    abstract fun getSongDAO(): SongDAO
}