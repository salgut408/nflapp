package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.nfl


import com.google.gson.annotations.SerializedName

data class Calendar(
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("entries")
    val entries: List<Entry> = listOf(),
    @SerializedName("label")
    val label: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("value")
    val value: String = ""
)