package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.VideoModel


data class Videos(

    @SerializedName("source")
    val source: String? = null,
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("headline")
    val headline: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("ad")
    val ad: Ad? = Ad(),
    @SerializedName("tracking")
    val tracking: Tracking? = Tracking(),
    @SerializedName("cerebroId")
    val cerebroId: String? = null,
    @SerializedName("lastModified")
    val lastModified: String? = null,
    @SerializedName("originalPublishDate")
    val originalPublishDate: String? = null,
    @SerializedName("timeRestrictions")
    val timeRestrictions: TimeRestrictions? = TimeRestrictions(),
    @SerializedName("deviceRestrictions")
    val deviceRestrictions: DeviceRestrictions? = DeviceRestrictions(),
    @SerializedName("duration")
    val duration: Int? = null,
    @SerializedName("thumbnail")
    val thumbnail: String? = null,
    @SerializedName("links")
    val links: GameDetailsLinks? = GameDetailsLinks(),

    )

fun Videos.asDomain(): VideoModel {
    return VideoModel(
        source = source ?: "",
        id = id ?: 0,
        headline = headline ?: "",
        description = description ?: "",
        lastModified = lastModified ?: "",
        originalPublishDate = originalPublishDate ?: "",
        duration = duration ?: 0,
        thumbnail = thumbnail ?: "",
        links = links ?: GameDetailsLinks()
    )
}