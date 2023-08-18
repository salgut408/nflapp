package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.AthleteTennisModelXX

data class AthleteXX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("headshot")
    val headshot: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = ""
)

fun AthleteXX.asDomain(): AthleteTennisModelXX {
    return AthleteTennisModelXX(
        displayName = displayName,
        headshot = headshot,
        shortDisplayName = shortDisplayName
    )
}