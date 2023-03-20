package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.*


data class GameDetailsBoxscore(

  @SerializedName("teams")
  val teams: List<GameDetailsTeams> = listOf(),
  @SerializedName("players")
  val players: List<Players> = listOf(),
  @SerializedName("statistics")
  val statistics: List<Statistics> = listOf(),


  )

fun GameDetailsBoxscore.asDomain(): BoxScoreModel {
    return BoxScoreModel(
        teams = teams.map { it.asDomain() },
        players = players.map { it.asDomain() },
        statistics = statistics.map { it.asDomain() },
    )
}


data class Players(
  @SerializedName("team")
  val team: GameDetailsTeam? = GameDetailsTeam(),
  @SerializedName("statistics")
  val statistics: List<Statistics> = listOf(),
)

fun Players.asDomain(): BoxscorePlayerModel {
  return BoxscorePlayerModel(
    team = team?.asDomain() ?: GameDetailsTeamInfoModel(),
    statistics = statistics.map { it.asDomain() }
  )
}

data class Statistics(

  @SerializedName("name")
  val name: String? = null,
  @SerializedName("keys")
  val keys: List<String> = listOf(),
  @SerializedName("text")
  val text: String? = null,
  @SerializedName("labels")
  val labels: List<String> = listOf(),
  @SerializedName("descriptions")
  val descriptions: List<String> = listOf(),
  @SerializedName("athletes")
  val athletes: List<GameDetailsAthletes> = listOf(),
  @SerializedName("totals")
  val totals: List<String> = listOf(),

  )

fun Statistics.asDomain(): BoxscorePlayerStatisticModel {
  return BoxscorePlayerStatisticModel(
    name = name ?: "",
    keys = keys,
    text = text ?: "",
    descriptions = descriptions,
    athletes = athletes.map { it.asDomain() },
    totals = totals
  )
}

data class GameDetailsAthletes(

  @SerializedName("athlete")
  val athlete: GameDetailsAthlete? = GameDetailsAthlete(),
  @SerializedName("stats")
  val stats: List<String> = listOf(),
  )

fun GameDetailsAthletes.asDomain(): GameDetailsAthleteModel {
  return GameDetailsAthleteModel(
    athlete = athlete?.asDomain(),
    stats = stats
  )
}
