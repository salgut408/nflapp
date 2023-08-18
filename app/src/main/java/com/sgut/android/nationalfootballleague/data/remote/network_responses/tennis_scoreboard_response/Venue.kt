package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.VenueTennisModel

data class Venue(
    @SerializedName("court")
    val court: String = "",
    @SerializedName("fullName")
    val fullName: String = ""
)

fun Venue.asDomain(): VenueTennisModel{
    return VenueTennisModel(
        court = court,
        fullName = fullName,
    )
}