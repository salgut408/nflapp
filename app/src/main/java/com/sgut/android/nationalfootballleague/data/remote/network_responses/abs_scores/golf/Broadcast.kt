package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class Broadcast(
    @SerializedName("market")
    val market: String = "",
    @SerializedName("names")
    val names: List<String> = listOf()
)