package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Weather(
    @SerializedName("conditionId")
    val conditionId: String? = "",
    @SerializedName("displayValue")
    val displayValue: String? = "",
    @SerializedName("highTemperature")
    val highTemperature: Int? = 0,
    @SerializedName("temperature")
    val temperature: Int? = 0
)