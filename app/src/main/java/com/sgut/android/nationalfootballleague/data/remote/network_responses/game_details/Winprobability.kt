package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.WinprobabilityModel


data class Winprobability(

    @SerializedName("tiePercentage")
    val tiePercentage: Double? = null,
    @SerializedName("homeWinPercentage")
    val homeWinPercentage: Double? = null,
    @SerializedName("secondsLeft")
    val secondsLeft: Double? = null,
    @SerializedName("playId")
    val playId: String? = null,

    )

fun Winprobability.asDomain(): WinprobabilityModel {
    return WinprobabilityModel(
        tiePercentage = tiePercentage ?: 0.0,
        homeWinPercentage = homeWinPercentage ?: 0.0,
        secondsLeft = secondsLeft ?: 0.0,
        playId = playId ?: ""
    )
}