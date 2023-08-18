package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.LinescoreTennisModel

data class Linescore(
    @SerializedName("tiebreak")
    val tiebreak: Int = 0,
    @SerializedName("value")
    val value: Double = 0.0,
    @SerializedName("winner")
    val winner: Boolean = false
)

fun Linescore.asDomain(): LinescoreTennisModel{
    return LinescoreTennisModel(
        tiebreak = tiebreak,
        value = value,
        winner = winner
    )
}