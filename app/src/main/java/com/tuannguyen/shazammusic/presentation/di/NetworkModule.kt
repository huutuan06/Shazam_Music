package com.tuannguyen.shazammusic.presentation.di

import com.tuannguyen.shazammusic.BuildConfig
import com.tuannguyen.shazammusic.data.api.SongAPIService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideOKHTTPClient(): OkHttpClient.Builder {
        return OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                this.level = HttpLoggingInterceptor.Level.BODY
            })
//            .addInterceptor { chain ->
//                chain.proceed(chain.request().newBuilder()
//                    .addHeader("x-rapidapi-host","shazam.p.rapidapi.com").build())
//                chain.proceed(chain.request().newBuilder()
//                    .addHeader("x-rapidapi-key","9921b71bf3msh3576c6bf86857dcp116f59jsn02c90aceafc0").build())
//            }
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient.Builder): Retrofit {
        return Retrofit.Builder()
            .client(client.build())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
    }

    @Singleton
    @Provides
    fun provideNewsAPIService(retrofit: Retrofit): SongAPIService {
        return retrofit.create(SongAPIService::class.java)
    }
}