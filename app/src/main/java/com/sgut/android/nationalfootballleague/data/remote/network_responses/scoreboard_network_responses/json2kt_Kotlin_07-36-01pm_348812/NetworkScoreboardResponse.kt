package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.BasicScoreboardModel


data class NetworkScoreboardResponse(
    @SerializedName("leagues")
    val leagues: List<LeaguesScoreboard> = listOf(),
    @SerializedName("season")
    val season: SeasonScoreboard? = SeasonScoreboard(),
    @SerializedName("day")
    val day: DayScoreboard? = DayScoreboard(),
    @SerializedName("events")
    val events: List<EventScoreboard> = listOf(),
    )





fun NetworkScoreboardResponse.asDomain(): BasicScoreboardModel {
    return BasicScoreboardModel(
        league = leagues.first().asDomain(),
        day = day?.date ,
        events = events.map { it.asDomain() },
    )
}