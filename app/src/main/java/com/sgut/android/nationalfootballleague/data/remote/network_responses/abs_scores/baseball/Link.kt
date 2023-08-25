package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf()
)