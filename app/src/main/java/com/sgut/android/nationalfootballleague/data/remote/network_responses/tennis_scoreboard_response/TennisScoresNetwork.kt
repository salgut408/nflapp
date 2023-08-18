package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.ScoreboardTennisModel

data class TennisScoresNetwork(
    @SerializedName("day")
    val day: Day = Day(),
    @SerializedName("events")
    val events: List<Event> = listOf(),
    @SerializedName("leagues")
    val leagues: List<League> = listOf(),
    @SerializedName("season")
    val season: SeasonXX = SeasonXX()
)

fun TennisScoresNetwork.asDomain(): ScoreboardTennisModel{
    return ScoreboardTennisModel(
        day = day.asDomain(),
        events = events.map { it.asDomain() },
        league = leagues.first().asDomain(),
        season = season.asDomain()
    )
}
