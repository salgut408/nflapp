package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class Event(
    @SerializedName("competitions")
    val competitions: List<Competition> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("season")
    val season: Season = Season(),
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("uid")
    val uid: String = "",
)