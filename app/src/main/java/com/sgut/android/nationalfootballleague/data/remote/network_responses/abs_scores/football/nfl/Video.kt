package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.nfl


import com.google.gson.annotations.SerializedName

data class Video(
    @SerializedName("deviceRestrictions")
    val deviceRestrictions: DeviceRestrictions = DeviceRestrictions(),
    @SerializedName("duration")
    val duration: Int = 0,
    @SerializedName("headline")
    val headline: String = "",
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("links")
    val links: Links = Links(),
    @SerializedName("source")
    val source: String = "",
    @SerializedName("thumbnail")
    val thumbnail: String = "",
    @SerializedName("tracking")
    val tracking: Tracking = Tracking()
)