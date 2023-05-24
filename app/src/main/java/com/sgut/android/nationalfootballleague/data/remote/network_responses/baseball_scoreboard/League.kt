package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class League(
    @SerializedName("abbreviation")
    val abbreviation: String? = "",
    @SerializedName("calendar")
    val calendar: List<String>? = listOf(),
    @SerializedName("calendarEndDate")
    val calendarEndDate: String? = "",
    @SerializedName("calendarIsWhitelist")
    val calendarIsWhitelist: Boolean? = false,
    @SerializedName("calendarStartDate")
    val calendarStartDate: String? = "",
    @SerializedName("calendarType")
    val calendarType: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("logos")
    val logos: List<Logo>? = listOf(),
    @SerializedName("midsizeName")
    val midsizeName: String? = "",
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("season")
    val season: SeasonX? = SeasonX(),
    @SerializedName("slug")
    val slug: String? = "",
    @SerializedName("uid")
    val uid: String? = ""
)