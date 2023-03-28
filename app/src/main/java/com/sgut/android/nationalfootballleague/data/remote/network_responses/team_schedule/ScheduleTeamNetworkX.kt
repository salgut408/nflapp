package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleTeamModelX

data class ScheduleTeamNetworkX(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = ""
)

fun ScheduleTeamNetworkX.asDomain(): ScheduleTeamModelX {
    return ScheduleTeamModelX(
        id = id,
        name = name
    )
}