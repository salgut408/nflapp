package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.DayTennisModel

data class Day(
    @SerializedName("date")
    val date: String = ""
)

fun Day.asDomain(): DayTennisModel{
    return DayTennisModel(
        date = date
    )
}
