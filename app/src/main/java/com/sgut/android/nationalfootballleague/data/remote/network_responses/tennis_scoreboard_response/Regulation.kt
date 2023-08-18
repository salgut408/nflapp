package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.RegulationTennisModel

data class Regulation(
    @SerializedName("periods")
    val periods: Int = 0
)

fun Regulation.asDomain(): RegulationTennisModel{
    return RegulationTennisModel(
        periods = periods
    )
}