package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class Link(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("isHidden")
    val isHidden: Boolean = false,
    @SerializedName("rel")
    val rel: List<String> = listOf()
)