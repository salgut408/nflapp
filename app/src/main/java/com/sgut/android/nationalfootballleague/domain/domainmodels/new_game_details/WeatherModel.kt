package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class WeatherModel(
    val temperature: String = "",
    val highTemperature: Int = 0,
    val lowTemperature: Int = 0,
    val conditionId: String = "",
    val gust: Int = 0,
    val precipitation: Int = 0,
)
