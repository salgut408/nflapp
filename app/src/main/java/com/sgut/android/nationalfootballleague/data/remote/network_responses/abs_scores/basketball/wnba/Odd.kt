package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.wnba


import com.google.gson.annotations.SerializedName

data class Odd(
    @SerializedName("details")
    val details: String = "",
    @SerializedName("overUnder")
    val overUnder: Double = 0.0,
    @SerializedName("provider")
    val provider: Provider = Provider()
)