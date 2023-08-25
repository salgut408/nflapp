package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.nfl


import com.google.gson.annotations.SerializedName

data class LinkX(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf()
)