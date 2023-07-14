package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("competitions")
    val competitions: List<Competition>? = listOf(),
    @SerializedName("date")
    val date: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("season")
    val season: Season? = Season(),
    @SerializedName("shortName")
    val shortName: String? = "",
    @SerializedName("status")
    val status: StatusX? = StatusX(),
    @SerializedName("uid")
    val uid: String? = "",
    @SerializedName("weather")
    val weather: Weather? = Weather()
)