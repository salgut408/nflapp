package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.nba


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("isExternal")
    val isExternal: Boolean = false,
    @SerializedName("isPremium")
    val isPremium: Boolean = false,
    @SerializedName("rel")
    val rel: List<String> = listOf(),
    @SerializedName("text")
    val text: String = ""
)