package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    @SerializedName("id")
    val artistId: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("header_image_url")
    val headerImageUrl: String?,
    @SerializedName("image_url")
    val artistImageUrl: String?,
    @SerializedName("facebook_name")
    val facebookName: String?,
    @SerializedName("instagram_name")
    val instagramName: String?,
    @SerializedName("url")
    val artistUrl: String?
): Parcelable