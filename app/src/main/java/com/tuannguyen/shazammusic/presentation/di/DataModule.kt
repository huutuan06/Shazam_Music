package com.tuannguyen.shazammusic.presentation.di

import com.tuannguyen.shazammusic.data.api.SongAPIService
import com.tuannguyen.shazammusic.data.repository.DataSource.SongRemoteRepository
import com.tuannguyen.shazammusic.data.repository.DataSourceImpl.SongRemoteRepositoryImpl
import com.tuannguyen.shazammusic.data.repository.SongRepositoryImpl
import com.tuannguyen.shazammusic.domain.repository.SongRepository
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
    fun provideSongRemoteRepository(songAPIService: SongAPIService): SongRemoteRepository {
        return SongRemoteRepositoryImpl(songAPIService)
    }

    @Singleton
    @Provides
    fun provideSongRepository(songRemoteRepository: SongRemoteRepository): SongRepository {
        return SongRepositoryImpl(songRemoteRepository)
    }
}
