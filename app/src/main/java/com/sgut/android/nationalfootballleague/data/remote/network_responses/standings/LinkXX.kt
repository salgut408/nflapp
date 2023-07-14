package com.sgut.android.nationalfootballleague.data.remote.network_responses.standings


import com.google.gson.annotations.SerializedName

data class LinkXX(
    @SerializedName("href")
    val href: String = "",
    @SerializedName("isExternal")
    val isExternal: Boolean = false,
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