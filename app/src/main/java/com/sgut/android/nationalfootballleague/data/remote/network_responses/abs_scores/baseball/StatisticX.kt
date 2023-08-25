package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class StatisticX(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("displayValue")
    val displayValue: String = "",
    @SerializedName("name")
    val name: String = ""
)