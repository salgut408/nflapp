package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.SeasonTennisModelXX

data class SeasonXX(
    @SerializedName("type")
    val type: Int = 0,
    @SerializedName("year")
    val year: Int = 0
)

fun SeasonXX.asDomain(): SeasonTennisModelXX{
    return SeasonTennisModelXX(
        type = type,
        year = year
    )
}