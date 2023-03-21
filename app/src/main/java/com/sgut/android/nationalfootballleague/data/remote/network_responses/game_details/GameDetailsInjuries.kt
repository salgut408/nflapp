package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsInjuriesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.InjTeamModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.InjuriesItemModel


data class GameDetailsInjuries(
  @SerializedName("team")
  val team: InjTeam = InjTeam(),
  @SerializedName("injuries")
  val injuries: List<InjuriesItem> = listOf(),
  )
fun GameDetailsInjuries.asDomain(): GameDetailsInjuriesListModel {
  return GameDetailsInjuriesListModel(
    team = team.asDomain(),
    injuries = injuries.map { it.asDomain() }
  )
}

data class InjTeam(
  @SerializedName("id")
  val id: String = "",
  @SerializedName("uid")
  val uid: String = "",
  @SerializedName("displayName")
  val displayName: String = "",
  @SerializedName("logo")
  val logo: String = "",
  )

fun InjTeam.asDomain(): InjTeamModel {
  return InjTeamModel(
    id = id,
    displayName = displayName,
    logo = logo
  )
}

data class InjuriesItem(
  @SerializedName("status")
  val status: String = "",
  @SerializedName("date")
  val date: String = "",
  @SerializedName("athlete")
  val athlete: GameDetailsAthlete = GameDetailsAthlete(),
  @SerializedName("type")
  val type: GameDetailsType = GameDetailsType(),
  )

fun InjuriesItem.asDomain(): InjuriesItemModel {
  return InjuriesItemModel(
    status = status,
    date = date,
    athlete = athlete.asDomain(),
    type = type
  )
}