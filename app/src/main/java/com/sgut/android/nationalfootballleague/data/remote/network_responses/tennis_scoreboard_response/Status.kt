package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.StatusTennisModel

data class Status(
    @SerializedName("period")
    val period: Int = 0,
    @SerializedName("type")
    val type: Type = Type()
)

fun Status.asDomain(): StatusTennisModel{
    return StatusTennisModel(
        period = period,
        type = type.asDomain()
    )
}