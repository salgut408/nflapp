package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class Odd(
    @SerializedName("awayTeamOdds")
    val awayTeamOdds: AwayTeamOdds = AwayTeamOdds(),
    @SerializedName("details")
    val details: String = "",
    @SerializedName("drawOdds")
    val drawOdds: DrawOdds = DrawOdds(),
    @SerializedName("homeTeamOdds")
    val homeTeamOdds: HomeTeamOdds = HomeTeamOdds(),
    @SerializedName("overUnder")
    val overUnder: Double = 0.0,
    @SerializedName("provider")
    val provider: Provider = Provider()
)