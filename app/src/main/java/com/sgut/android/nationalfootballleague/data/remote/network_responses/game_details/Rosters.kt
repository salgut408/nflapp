package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.RosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.RostersModel

data class Rosters(
    @SerializedName("homeAway") val homeAway: String = "",
    @SerializedName("winner") val winner: Boolean = false,
    @SerializedName("team") val team: Team = Team(),
    @SerializedName("roster") val roster: List<Roster> = arrayListOf(),
)

fun Rosters.asDomain(): RostersModel {
    return RostersModel(
        homeAway = homeAway,
        winner = winner,
        team = team.asDomainModel(),
        roster = roster.map { it.asDomain() }
    )
}

data class Roster(
    @SerializedName("active")
    val active: Boolean = false,
    @SerializedName("starter")
    val starter: Boolean = false,
    @SerializedName("athlete")
    val athlete: GameDetailsAthlete = GameDetailsAthlete(),
    @SerializedName("position")
    val position: GameDetailsPosition = GameDetailsPosition(),
    @SerializedName("batOrder")
    val batOrder: Int = 0,
//    @SerializedName("subbedIn")
//    val subbedIn: Boolean = false,
//    @SerializedName("subbedOut")
//    val subbedOut: Boolean = false,
    @SerializedName("stats")
    val stats: List<GameDetailsStats> = listOf(),
    @SerializedName("jersey")
    var jersey: String = "",

    )

fun Roster.asDomain(): RosterModel {
    return RosterModel(
        active = active,
        starter = starter,
        athlete = athlete.asDomain(),
        position = position.asDomain(),
        batOrder = batOrder,
//        subbedIn = subbedIn,
//        subbedOut = subbedOut,
        stats = stats.map { it.asDomain() },
        jersey = jersey
    )
}


