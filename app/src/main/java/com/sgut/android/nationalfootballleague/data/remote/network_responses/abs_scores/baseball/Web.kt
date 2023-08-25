package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class Web(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("self")
    val self: Self = Self(),
    @SerializedName("short")
    val short: Short = Short()
)