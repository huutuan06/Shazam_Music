package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "songs")
@Parcelize
data class Song(
    @PrimaryKey(autoGenerate = true)
    val primaryKey: Int,
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("full_title")
    val fullTitle: String? = "",
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("primary_artist")
    @Embedded
    val primaryArtist: Artist?,
    @SerializedName("song_art_image_thumbnail_url")
    val thumbnailUrl: String?,
    @SerializedName("song_art_image_url")
    val ImageUrl: String?,
    @SerializedName("url")
    val url: String?
): Parcelable
