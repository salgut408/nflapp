package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsBoxscore (

  @SerializedName("teams" ) var teams : List<GameDetailsTeams> = listOf(),
  @SerializedName("players" ) var players : List<Players> = listOf()


)


  data class Players (
@SerializedName("team"       ) var team       : GameDetailsTeam?                 = GameDetailsTeam(),
@SerializedName("statistics" ) var statistics : List<Statistics> = listOf()
)

data class Statistics (

  @SerializedName("name"         ) var name         : String?             = null,
  @SerializedName("keys"         ) var keys         : List<String>   = listOf(),
  @SerializedName("text"         ) var text         : String?             = null,
  @SerializedName("labels"       ) var labels       : List<String>   = listOf(),
  @SerializedName("descriptions" ) var descriptions : List<String>   = listOf(),
  @SerializedName("athletes"     ) var athletes     : List<GameDetailsAthletes> = listOf(),
  @SerializedName("totals"       ) var totals       : List<String>   = listOf()

)

data class GameDetailsAthletes (

  @SerializedName("athlete" ) var athlete : GameDetailsAthlete?          = GameDetailsAthlete(),
  @SerializedName("stats"   ) var stats   : List<String> = listOf()

)
