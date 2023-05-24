package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href")
    val href: String? = "",
    @SerializedName("rel")
    val rel: List<String?>? = listOf()
)