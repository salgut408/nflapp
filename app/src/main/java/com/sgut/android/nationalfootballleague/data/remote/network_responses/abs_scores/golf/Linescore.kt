package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class Linescore(
    @SerializedName("linescores")
    val linescores: List<LinescoreX> = listOf(),
    @SerializedName("statistics")
    val statistics: Statistics = Statistics(),
    @SerializedName("value")
    val value: Double = 0.0
)