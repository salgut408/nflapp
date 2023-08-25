package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.college


import com.google.gson.annotations.SerializedName

data class Entry(
    @SerializedName("alternateLabel")
    val alternateLabel: String = "",
    @SerializedName("detail")
    val detail: String = "",
    @SerializedName("endDate")
    val endDate: String = "",
    @SerializedName("label")
    val label: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("value")
    val value: String = ""
)