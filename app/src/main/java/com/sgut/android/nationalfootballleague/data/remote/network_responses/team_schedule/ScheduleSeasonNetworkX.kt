package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleSeasonModelX

data class ScheduleSeasonNetworkX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("half")
    val half: Int = 0,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("type")
    val type: Int = 0,
    @SerializedName("year")
    val year: Int = 0
)

fun ScheduleSeasonNetworkX.asDomain(): ScheduleSeasonModelX {
    return ScheduleSeasonModelX(
        displayName = displayName,
        name = name,
        year = year
    )
}