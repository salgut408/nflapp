package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class AwayTeamOdds(
    @SerializedName("favorite")
    val favorite: Boolean = false,
    @SerializedName("moneyLine")
    val moneyLine: Int = 0,
    @SerializedName("spreadOdds")
    val spreadOdds: Double = 0.0,
    @SerializedName("team")
    val team: TeamXXX = TeamXXX(),
    @SerializedName("underdog")
    val underdog: Boolean = false
)