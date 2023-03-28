package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleTeamModel

data class ScheduleTeamNetwork(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("links")
    val links: List<ScheduleLinkNetwork> = listOf(),
    @SerializedName("location")
    val location: String = "",
    @SerializedName("logos")
    val logos: List<ScheduleLogoNetwork> = listOf(),
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = ""
)

fun ScheduleTeamNetwork.asDomain(): ScheduleTeamModel {
    return ScheduleTeamModel(
        abbreviation = abbreviation,
        displayName = displayName,
        id = id,
        logos = logos.getOrNull(0)?.href ?: "",
        shortDisplayName = shortDisplayName
    )
}