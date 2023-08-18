package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.RosterTennisModel

data class Roster(
    @SerializedName("athletes")
    val athletes: List<AthleteX> = listOf(),
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = ""
)

fun Roster.asDomain(): RosterTennisModel{
    return RosterTennisModel(
        athletes = athletes.map { it.asDomain() },
        displayName = displayName,
        shortDisplayName = shortDisplayName
    )
}