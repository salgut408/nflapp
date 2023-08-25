package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.college


import com.google.gson.annotations.SerializedName

data class Athlete(
    @SerializedName("active")
    val active: Boolean = false,
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("headshot")
    val headshot: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("jersey")
    val jersey: String = "",
    @SerializedName("links")
    val links: List<Link> = listOf(),
    @SerializedName("position")
    val position: Position = Position(),
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("team")
    val team: TeamX = TeamX()
)