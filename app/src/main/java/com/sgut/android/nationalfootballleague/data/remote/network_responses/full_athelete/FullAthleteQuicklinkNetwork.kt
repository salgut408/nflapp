package com.sgut.android.nationalfootballleague.data.remote.network_responses.full_athelete


import com.google.gson.annotations.SerializedName

data class FullAthleteQuicklinkNetwork(
    @SerializedName("items")
    val items: List<FullAthleteItemNetworkX> = listOf(),
    @SerializedName("text")
    val text: String = "",
    @SerializedName("title")
    val title: String = ""
)