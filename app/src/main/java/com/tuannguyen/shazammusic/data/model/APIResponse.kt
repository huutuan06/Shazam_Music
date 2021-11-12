package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class APIResponse(
    @SerializedName("tracks")
    val tracks: List<SongInfo>?,
    @SerializedName("artists")
    val artists: List<Artist>?,
): Parcelable