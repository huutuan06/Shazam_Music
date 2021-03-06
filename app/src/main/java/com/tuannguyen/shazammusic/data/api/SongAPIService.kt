package com.tuannguyen.shazammusic.data.api

import com.tuannguyen.shazammusic.data.model.APIResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface SongAPIService {

    @Headers(
        "x-rapidapi-host:genius.p.rapidapi.com",
        "x-rapidapi-key:9921b71bf3msh3576c6bf86857dcp116f59jsn02c90aceafc0"
    )
    @GET("/artists/1/songs")
    suspend fun getSongs(): Response<APIResponse>

    @Headers(
        "x-rapidapi-host:genius.p.rapidapi.com",
        "x-rapidapi-key:9921b71bf3msh3576c6bf86857dcp116f59jsn02c90aceafc0"
    )
    @GET("/search")
    suspend fun getSearchedSongs(@Query("q") searchQuery: String): Response<APIResponse>
}
