package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsEventModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsOpponentModel


data class GameDetailsEvents(
    @SerializedName("id")
    val id: String = "",
//  @SerializedName("links" ) var links : List<EventLinks> = listOf(),
    @SerializedName("atVs")
    val atVs: String = "",
    @SerializedName("gameDate")
    val gameDate: String = "",
    @SerializedName("score")
    val score: String = "",
    @SerializedName("homeTeamScore")
    val homeTeamScore: String = "",
    @SerializedName("awayTeamScore")
    val awayTeamScore: String = "",
    @SerializedName("gameResult")
    val gameResult: String = "",
    @SerializedName("opponent") val
    opponent: Opponent = Opponent(),
    @SerializedName("opponentLogo") val
    opponentLogo: String = "",
    @SerializedName("leagueName") val
    leagueName: String = "",
    @SerializedName("leagueAbbreviation")
    val leagueAbbreviation: String = "",

    )

fun GameDetailsEvents.asDomain(): GameDetailsEventModel {
    return GameDetailsEventModel(
        id = id,
        atVs = atVs,
        gameDate = gameDate,
        score = score,
        homeTeamScore = homeTeamScore,
        awayTeamScore = awayTeamScore,
        gameResult = gameResult,
        opponent = opponent.asDomain(),
        leagueName = leagueName,
        leagueAbbreviation = leagueAbbreviation
    )
}

data class Opponent(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("logo")
    val logo: String = "",
    )
fun Opponent.asDomain(): GameDetailsOpponentModel {
    return GameDetailsOpponentModel(
        id = id,
        displayName = displayName,
        abbreviation = abbreviation,
        logo = logo
    )
}

data class EventLinks(
    @SerializedName("href") var href: String = "",
    @SerializedName("text") var text: String = "",
)