package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.SituationTennisModel

data class Situation(
    @SerializedName("onFirst")
    val onFirst: Boolean = false,
    @SerializedName("onSecond")
    val onSecond: Boolean = false,
    @SerializedName("onThird")
    val onThird: Boolean = false
)

fun Situation.asDomain(): SituationTennisModel{
    return SituationTennisModel(
        onFirst = onFirst,
        onSecond = onSecond,
        onThird = onThird
    )
}