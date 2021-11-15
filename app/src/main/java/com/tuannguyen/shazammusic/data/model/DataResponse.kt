package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataResponse(
//    @SerializedName("songs")
    val songs: List<Song>?,
//    @SerializedName("artist")
    val artist: Artist?,
//    @SerializedName("hits")
    val hits: List<SearchResponse>?,
//    @SerializedName("songs")
    val song: Song?
): Parcelable
