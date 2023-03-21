package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.WeatherModel


data class Weather(

  @SerializedName("temperature")
  val temperature: String? = null,
  @SerializedName("highTemperature")
  val highTemperature: Int? = null,
  @SerializedName("lowTemperature")
  val lowTemperature: Int? = null,
  @SerializedName("conditionId")
  val conditionId: String? = null,
  @SerializedName("gust")
  val gust: Int? = null,
  @SerializedName("precipitation")
  val precipitation: Int? = null,
  @SerializedName("link")
  val link: GameDetailsLink? = GameDetailsLink(),

  )
fun Weather.asDomain(): WeatherModel {
  return WeatherModel(
    temperature = temperature ?: "",
    highTemperature = highTemperature ?: 0,
    lowTemperature = lowTemperature ?: 0,
    conditionId = conditionId ?: "",
    gust = gust ?: 0,
    precipitation = precipitation ?: 0
  )
}