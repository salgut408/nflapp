package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class HomeTeamOdds(
    @SerializedName("averageScore")
    val averageScore: Double? = 0.0,
    @SerializedName("favorite")
    val favorite: Boolean? = false,
    @SerializedName("moneyLine")
    val moneyLine: Int? = 0,
    @SerializedName("spreadOdds")
    val spreadOdds: Double? = 0.0,
    @SerializedName("spreadRecord")
    val spreadRecord: SpreadRecord? = SpreadRecord(),
    @SerializedName("team")
    val team: TeamXXXXXX? = TeamXXXXXX(),
    @SerializedName("underdog")
    val underdog: Boolean? = false,
    @SerializedName("winPercentage")
    val winPercentage: Double? = 0.0
)