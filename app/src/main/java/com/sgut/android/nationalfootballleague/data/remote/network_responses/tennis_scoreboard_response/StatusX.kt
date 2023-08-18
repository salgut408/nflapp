package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.StatusTennisModelX

data class StatusX(
    @SerializedName("period")
    val period: Int = 0,
    @SerializedName("type")
    val type: TypeX = TypeX()
)

fun StatusX.asDomain(): StatusTennisModelX {
    return StatusTennisModelX(
        period = period,
        type = type.asDomain()
    )
}