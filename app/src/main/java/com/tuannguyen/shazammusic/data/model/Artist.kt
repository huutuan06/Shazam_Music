package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    @SerializedName("avatar")
    val avatar: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("verified")
    val verified: Boolean? = false,
    @SerializedName("weburl")
    val webUrl: String?,
    @SerializedName("adamid")
    val adamId: String?
): Parcelable