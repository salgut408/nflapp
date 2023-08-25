package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class Status(
    @SerializedName("clock")
    val clock: Double = 0.0,
    @SerializedName("displayClock")
    val displayClock: String = "",
    @SerializedName("featuredAthletes")
    val featuredAthletes: List<FeaturedAthlete> = listOf(),
    @SerializedName("period")
    val period: Int = 0,
    @SerializedName("type")
    val type: TypeX = TypeX()
)