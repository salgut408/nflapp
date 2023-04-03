package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteLogoNetwork(
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("href")
    val href: String = "",
    @SerializedName("rel")
    val rel: List<String> = listOf(),
    @SerializedName("width")
    val width: Int = 0
)