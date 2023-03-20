package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel


data class GameDetailsAthlete(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("uid")
  val uid: String? = null,
  @SerializedName("guid")
  val guid: String? = null,
  @SerializedName("lastName")
  val lastName: String? = null,
  @SerializedName("fullName")
  val fullName: String? = null,
  @SerializedName("displayName")
  val displayName: String? = null,
  @SerializedName("shortName")
  val shortName: String? = null,
  @SerializedName("links")
  val links: ArrayList<GameDetailsLinks> = arrayListOf(),
  @SerializedName("headshot")
  val headshot: GameDetailsHeadshot? = GameDetailsHeadshot(),
  @SerializedName("jersey")
  val jersey: String? = null,
  @SerializedName("position")
  val position: GameDetailsPosition? = GameDetailsPosition(),

  )

fun GameDetailsAthlete.asDomain(): GameDetailsAthleteDetailsModel {
  return GameDetailsAthleteDetailsModel(
    id = id ?: "",
    uid = uid ?: "",
    lastName = lastName ?: "",
    fullName = fullName ?: "",
    displayName = displayName ?: "",
    shortName = shortName ?: "",
    headshot = headshot?.asDomain(),
    jersey = jersey ?: "",
    position = position?.asDomain()
  )
}