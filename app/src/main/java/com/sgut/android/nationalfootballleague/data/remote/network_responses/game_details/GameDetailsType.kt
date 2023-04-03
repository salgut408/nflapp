package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsTypeModel


data class GameDetailsType(

  @SerializedName("id")
  val id: String = "",
  @SerializedName("name")
  val name: String = "",
  @SerializedName("completed")
  val completed: Boolean = false,
  @SerializedName("description")
  val description: String = "",
  @SerializedName("detail")
  val gameTimeDetail: String = "",
  @SerializedName("shortDetail")
  val shortGameTimeDetail: String = "",
  @SerializedName("text")
  val text: String = "",
  @SerializedName("abbreviation")
  val abbreviation: String = "",





  )

fun GameDetailsType.asDomain(): GameDetailsTypeModel {
  return GameDetailsTypeModel(
    name = name,
    completed = completed,
    description = description,
    gameTimeDetail = gameTimeDetail,
    shortGameTimeDetail = shortGameTimeDetail,
    text = text,
    abbreviation = abbreviation,
  )
}