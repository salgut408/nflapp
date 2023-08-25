package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.college


import com.google.gson.annotations.SerializedName

data class Broadcast(
    @SerializedName("market")
    val market: String = "",
    @SerializedName("names")
    val names: List<String> = listOf()
)