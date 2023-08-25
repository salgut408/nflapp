package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.wnba


import com.google.gson.annotations.SerializedName

data class Statistic(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("rankDisplayValue")
    val rankDisplayValue: String = ""
)