package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Meta(
    @SerializedName("status")
    val status: Int?
): Parcelable
