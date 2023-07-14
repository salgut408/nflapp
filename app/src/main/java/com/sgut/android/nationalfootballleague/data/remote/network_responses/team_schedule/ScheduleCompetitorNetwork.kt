package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule.ScheduleCompetitorModel

data class ScheduleCompetitorNetwork(
    @SerializedName("homeAway")
    val homeAway: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("order")
    val order: Int = 0,
    @SerializedName("record")
    val record: List<ScheduleRecordNetwork>? = listOf(),
    @SerializedName("score")
    val score: ScheduleScoreNetwork? = ScheduleScoreNetwork(),
    @SerializedName("team")
    val team: ScheduleTeamNetwork = ScheduleTeamNetwork(),
    @SerializedName("type")
    val type: String = "",
    @SerializedName("winner")
    val winner: Boolean? = false
)

fun ScheduleCompetitorNetwork.asDomain(): ScheduleCompetitorModel {
    return ScheduleCompetitorModel(
        homeAway = homeAway,
        id = id,
        team = team.asDomain(),
        winner = winner
    )
}