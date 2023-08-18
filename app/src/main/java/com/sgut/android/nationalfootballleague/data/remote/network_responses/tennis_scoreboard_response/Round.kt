package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.RoundTennisModel

data class Round(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = ""
)

fun Round.asDomain(): RoundTennisModel{
    return RoundTennisModel(
        displayName = displayName,
        id = id
    )
}