package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleSeasonTypeModel

data class ScheduleSeasonTypeNetwork(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("type")
    val type: Int = 0
)

fun ScheduleSeasonTypeNetwork.asDomain(): ScheduleSeasonTypeModel {
    return ScheduleSeasonTypeModel(
        abbreviation = abbreviation,
        id = id,
         name = name,
        type = type
    )
}