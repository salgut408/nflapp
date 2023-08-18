package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.AthleteTennisModelX

data class AthleteX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("guid")
    val guid: String = "",

    @SerializedName("shortName")
    val shortName: String = ""
)

fun AthleteX.asDomain(): AthleteTennisModelX{
    return AthleteTennisModelX(
        displayName = displayName,
        fullName = fullName,
        guid = guid,
        shortName = shortName
    )
}