package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class StatusX(
    @SerializedName("clock")
    val clock: Double = 0.0,
    @SerializedName("displayClock")
    val displayClock: String = "",
    @SerializedName("type")
    val type: Type = Type()
)