package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.WeatherModel


data class Weather(

  @SerializedName("temperature")
  val temperature: String = "",
  @SerializedName("highTemperature")
  val highTemperature: Int = 0,
  @SerializedName("lowTemperature")
  val lowTemperature: Int = 0,
  @SerializedName("conditionId")
  val conditionId: String = "",
  @SerializedName("gust")
  val gust: Int = 0,
  @SerializedName("precipitation")
  val precipitation: Int = 0,
  @SerializedName("link")
  val link: GameDetailsLink? = GameDetailsLink(),

  )
fun Weather.asDomain(): WeatherModel {
  return WeatherModel(
    temperature = temperature,
    highTemperature = highTemperature,
    lowTemperature = lowTemperature,
    conditionId = conditionId ?: "",
    gust = gust,
    precipitation = precipitation ?: 0
  )
}