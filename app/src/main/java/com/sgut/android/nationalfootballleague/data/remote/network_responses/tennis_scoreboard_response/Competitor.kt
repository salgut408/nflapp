package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.CompetitorTennisModel

data class Competitor(
    @SerializedName("athlete")
    val athlete: Athlete = Athlete(),
    @SerializedName("curatedRank")
    val curatedRank: CuratedRank = CuratedRank(),
    @SerializedName("homeAway")
    val homeAway: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("linescores")
    val linescores: List<Linescore> = listOf(),
    @SerializedName("order")
    val order: Int = 0,
    @SerializedName("possession")
    val possession: Boolean = false,
    @SerializedName("roster")
    val roster: Roster = Roster(),
    @SerializedName("statistics")
    val statistics: List<Any> = listOf(),
    @SerializedName("type")
    val type: String = "",
    @SerializedName("uid")
    val uid: String = "",
    @SerializedName("winner")
    val winner: Boolean = false
)

fun Competitor.asDomain(): CompetitorTennisModel{
    return CompetitorTennisModel(
        athlete = athlete.asDomain(),
        curatedRank = curatedRank.asDomain(),
        homeAway = homeAway,
        id = id,
        linescores = linescores.map { it.asDomain() },
        order = order,
        possession = possession,
        roster = roster.asDomain(),
        statistics = statistics,
        type = type,
        uid = uid,
        winner = winner
    )
}