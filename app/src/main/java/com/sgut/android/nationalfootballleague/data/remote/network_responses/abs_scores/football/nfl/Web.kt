package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.nfl


import com.google.gson.annotations.SerializedName

data class Web(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("short")
    val short: Short = Short()
)