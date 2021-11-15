package com.tuannguyen.shazammusic.presentation.di

import android.app.Application
import androidx.room.Room
import com.tuannguyen.shazammusic.data.db.SongDAO
import com.tuannguyen.shazammusic.data.db.SongDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Singleton
    @Provides
    fun provideNewsDatabase(app: Application): SongDatabase {
        return Room.databaseBuilder(app, SongDatabase::class.java, "news_db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsDao(songDatabase: SongDatabase): SongDAO {
        return songDatabase.getSongDAO()
    }
}
