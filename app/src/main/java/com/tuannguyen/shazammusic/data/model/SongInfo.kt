package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SongInfo(
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("key")
    val key: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("subtitle")
    val subtitle: String? = "",
    @SerializedName("image")
    val songImages: SongImages?
): Parcelable