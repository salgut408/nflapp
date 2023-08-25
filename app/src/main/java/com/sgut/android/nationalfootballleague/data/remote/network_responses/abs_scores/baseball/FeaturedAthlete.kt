package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class FeaturedAthlete(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("athlete")
    val athlete: AthleteXXX = AthleteXXX(),
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("playerId")
    val playerId: Int = 0,
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("statistics")
    val statistics: List<StatisticX> = listOf(),
    @SerializedName("team")
    val team: TeamX = TeamX()
)