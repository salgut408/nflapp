package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleAthleteModel

data class ScheduleAthleteNetwork(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("lastName")
    val lastName: String = "",
    @SerializedName("record")
    val record: String = "",
    @SerializedName("saves")
    val saves: String = "",
    @SerializedName("shortName")
    val shortName: String = ""
)

fun ScheduleAthleteNetwork.asDomain(): ScheduleAthleteModel {
    return ScheduleAthleteModel(
        displayName = displayName,
        id = id,
        lastName = lastName,
        record = record,
        saves = saves,
        shortName = shortName,
    )
}