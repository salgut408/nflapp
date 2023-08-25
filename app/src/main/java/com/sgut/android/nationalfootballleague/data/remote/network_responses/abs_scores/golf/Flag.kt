package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class Flag(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("href")
    val href: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf()
)