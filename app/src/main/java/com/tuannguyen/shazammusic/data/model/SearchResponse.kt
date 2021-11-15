package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class SearchResponse(
    @SerializedName("type")
    val type: String?,
    @SerializedName("result")
    val song: Song?
): Parcelable