package com.tuannguyen.shazammusic.presentation.di

import com.tuannguyen.shazammusic.data.api.SongAPIService
import com.tuannguyen.shazammusic.data.repository.DataSource.SongRemoteRepository
import com.tuannguyen.shazammusic.data.repository.DataSourceImpl.SongRemoteRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideSongRepository(songAPIService: SongAPIService): SongRemoteRepository {
        return SongRemoteRepositoryImpl(songAPIService)
    }
}