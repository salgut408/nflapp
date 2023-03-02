package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsLeaders(

  @SerializedName("team") var team: GameDetailsTeam? = GameDetailsTeam(),
  @SerializedName("leaders") var leaders: List<GameDetailsLeaders2> = listOf(),

  )

data class GameDetailsLeaders2(
  @SerializedName("name") var name: String = "",
  @SerializedName("displayName") var displayName: String = "",
  @SerializedName("leaders") var leadersAthlete: List<AthleteLeaders> = listOf(),
  )

data class AthleteLeaders(
  @SerializedName("displayValue") var displayValue: String = "",
  @SerializedName("athlete") var athlete: GameDetailsAthlete? = null,

  )

