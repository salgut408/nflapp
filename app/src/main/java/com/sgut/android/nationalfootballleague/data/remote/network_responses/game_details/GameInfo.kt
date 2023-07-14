package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameInfoModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.OfficialModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.OfficialsPositionModel


data class GameInfo (

  @SerializedName("venue"   )
  val venue   : GameDetailsVenue   = GameDetailsVenue(),
  @SerializedName("weather" )
  val weather : Weather = Weather(),
  @SerializedName("attendance" )
val attendance : Int = 0,
  @SerializedName("officials")
  val officials: List<Official> = listOf(),

  )


data class Official(
  @SerializedName("displayName")
  val displayName: String? = "",
  @SerializedName("order")
  val order: Int? = 0,
  @SerializedName("position")
  val position: OfficialsPosition = OfficialsPosition()
)

fun Official.asDomain(): OfficialModel {
  return OfficialModel(
    displayName = displayName,
    order = order,
    position = position.asDomain()
  )
}





data class OfficialsPosition(
  @SerializedName("displayName")
  val displayName: String? = "",
  @SerializedName("id")
  val id: String? = "",
  @SerializedName("name")
  val name: String? = ""
)

fun OfficialsPosition.asDomain(): OfficialsPositionModel {
  return OfficialsPositionModel(
    displayName = displayName,
  id = id,
    name = name
    )
}

fun GameInfo.asDomain(): GameInfoModel {
  return GameInfoModel(
    venue = venue.asDomain(),
    weather = weather.asDomain(),
    attendance = attendance,
    officials = officials.map { it.asDomain() }
  )



}