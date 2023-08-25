package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class Probable(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("athlete")
    val athlete: AthleteX = AthleteX(),
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("playerId")
    val playerId: Int = 0,
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",
    @SerializedName("statistics")
    val statistics: List<Statistic> = listOf()
)