package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.team_stats_models.TeamStatsModelModel

data class NetworkStat(
    @SerializedName("requestedSeason")
    val requestedSeason: RequestedSeason = RequestedSeason(),
    @SerializedName("results")
    val results: Results = Results(),
    @SerializedName("season")
    val season: Season = Season(),
    @SerializedName("status")
    val status: String = "",
    @SerializedName("team")
    val team: Team = Team()
)

fun NetworkStat.asDomain(): TeamStatsModelModel {
    return TeamStatsModelModel(
        results = results,
//        season = season,
//        team = team
    )
}