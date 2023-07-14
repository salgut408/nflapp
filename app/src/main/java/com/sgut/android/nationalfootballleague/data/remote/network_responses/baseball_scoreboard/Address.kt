package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Address(
    @SerializedName("city")
    val city: String? = "",
    @SerializedName("state")
    val state: String? = ""
)