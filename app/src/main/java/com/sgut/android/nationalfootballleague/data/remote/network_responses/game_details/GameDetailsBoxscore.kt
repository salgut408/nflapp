package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.BoxScoreModel


data class GameDetailsBoxscore (

  @SerializedName("teams" )
  val teams : List<GameDetailsTeams> = listOf(),
  @SerializedName("players" )
  val players : List<Players> = listOf(),
  @SerializedName("statistics" )
  val statistics : List<Statistics> = listOf()


)

fun GameDetailsBoxscore.asDomain(): BoxScoreModel {
  return BoxScoreModel(
    teams = teams,
    players = players,
    statistics = statistics,
  )
}


  data class Players (
@SerializedName("team"       ) val team       : GameDetailsTeam?                 = GameDetailsTeam(),
@SerializedName("statistics" ) val statistics : List<Statistics> = listOf()
)

data class Statistics (

  @SerializedName("name"         ) val name         : String?             = null,
  @SerializedName("keys"         ) val keys         : List<String>   = listOf(),
  @SerializedName("text"         ) val text         : String?             = null,
  @SerializedName("labels"       ) val labels       : List<String>   = listOf(),
  @SerializedName("descriptions" ) val descriptions : List<String>   = listOf(),
  @SerializedName("athletes"     ) val athletes     : List<GameDetailsAthletes> = listOf(),
  @SerializedName("totals"       ) val totals       : List<String>   = listOf()

)

data class GameDetailsAthletes (

  @SerializedName("athlete" ) val athlete : GameDetailsAthlete?          = GameDetailsAthlete(),
  @SerializedName("stats"   ) val stats   : List<String> = listOf()

)
