package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongImages(
    @SerializedName("background")
    val background: String?,
    @SerializedName("coverart")
    val coverArt: String?,
    @SerializedName("coverarthq")
    val coverArtHq: String?
): Parcelable