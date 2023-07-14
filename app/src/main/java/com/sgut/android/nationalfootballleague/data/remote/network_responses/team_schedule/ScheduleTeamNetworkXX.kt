package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleTeamModelXX

data class ScheduleTeamNetworkXX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("clubhouse")
    val clubhouse: String = "",
    @SerializedName("color")
    val color: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("groups")
    val groups: ScheduleGroupsNetwork = ScheduleGroupsNetwork(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("location")
    val location: String = "",
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("recordSummary")
    val recordSummary: String = "",
    @SerializedName("seasonSummary")
    val seasonSummary: String = ""
)

fun ScheduleTeamNetworkXX.asDomain(): ScheduleTeamModelXX {
    return ScheduleTeamModelXX(
        abbreviation = abbreviation,
        color = color,
        displayName = displayName,
        id = id,
        location = location,
        logo = logo,
        name = name,
        recordSummary = recordSummary,
        seasonSummary = seasonSummary
    )
}