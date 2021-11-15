package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Song(
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("full_title")
    val fullTitle: String? = "",
    @SerializedName("id")
    val id: String?,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("primary_artist")
    val primaryArtist: Artist?,
    @SerializedName("song_art_image_thumbnail_url")
    val thumbnailUrl: String?,
    @SerializedName("song_art_image_url")
    val ImageUrl: String?
): Parcelable
