package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class LinkX(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("isExternal")
    val isExternal: Boolean = false,
    @SerializedName("isHidden")
    val isHidden: Boolean = false,
    @SerializedName("isPremium")
    val isPremium: Boolean = false,
    @SerializedName("language")
    val language: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf(),
    @SerializedName("shortText")
    val shortText: String = "",
    @SerializedName("text")
    val text: String = ""
)