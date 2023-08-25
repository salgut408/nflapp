package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName

data class LogoComm(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("height")
    val height: Int = 0,
    @SerializedName("href")
    val href: String = "",
    @SerializedName("width")
    val width: Int = 0
)