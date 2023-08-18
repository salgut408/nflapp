package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.AthleteTennisModel

data class Athlete(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("flag")
    val flag: Flag = Flag(),
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("guid")
    val guid: String = "",
    @SerializedName("shortName")
    val shortName: String = ""
)

fun Athlete.asDomain(): AthleteTennisModel{
    return AthleteTennisModel(
        displayName = displayName,
        fullName = fullName,
        guid = guid,
        shortName = shortName,
        flag = flag.asDomain()
    )
}