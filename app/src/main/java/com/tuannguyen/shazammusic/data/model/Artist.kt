package com.tuannguyen.shazammusic.data.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    @SerializedName("id")
    val id: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("header_image_url")
    val headerImageUrl: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("facebook_name")
    val facebookName: String?,
    @SerializedName("instagram_name")
    val instagramName: String?,
    @SerializedName("url")
    val url: String?
): Parcelable