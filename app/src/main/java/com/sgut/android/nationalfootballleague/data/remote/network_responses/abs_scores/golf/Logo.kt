package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class Logo(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("href")
    val href: String = "",
    @SerializedName("lastUpdated")
    val lastUpdated: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf(),
    @SerializedName("width")
    val width: Int = 0
)