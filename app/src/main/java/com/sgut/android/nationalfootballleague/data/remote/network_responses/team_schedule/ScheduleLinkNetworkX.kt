package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_schedule


import com.google.gson.annotations.SerializedName

data class ScheduleLinkNetworkX(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf()
)