package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.AthleteLeaderModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsLeadersModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameLeadersModel


data class GameDetailsLeaders(

  @SerializedName("team")
  val team: GameDetailsTeam = GameDetailsTeam(),
  @SerializedName("leaders")
  val leaders: List<GameDetailsLeaders2> = listOf(),

  )
fun GameDetailsLeaders.asDomain(): GameDetailsLeadersModel {
  return GameDetailsLeadersModel(
    team = team.asDomain(),
    leaders = leaders.map { it.asDomain() }
  )
}

data class GameDetailsLeaders2(
  @SerializedName("name")
  val name: String = "",
  @SerializedName("displayName")
  val displayName: String = "",
  @SerializedName("leaders")
  val leadersAthlete: List<AthleteLeaders> = listOf(),
  )

fun GameDetailsLeaders2.asDomain(): GameLeadersModel {
  return GameLeadersModel(
    name = name,
    displayName = displayName,
    leadersAthlete = leadersAthlete.map { it.asDomain() }
  )
}

data class AthleteLeaders(
  @SerializedName("displayValue")
  val displayValue: String = "",
  @SerializedName("athlete")
  val athlete: GameDetailsAthlete = GameDetailsAthlete(),

  )
fun AthleteLeaders.asDomain(): AthleteLeaderModel {
  return AthleteLeaderModel(
    displayValue = displayValue,
    athlete = athlete.asDomain()
  )
}


