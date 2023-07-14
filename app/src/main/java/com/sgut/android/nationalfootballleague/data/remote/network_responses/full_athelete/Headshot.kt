package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class Headshot(
    @SerializedName("alt")
    val alt: String = "",
    @SerializedName("href")
    val href: String = ""
)