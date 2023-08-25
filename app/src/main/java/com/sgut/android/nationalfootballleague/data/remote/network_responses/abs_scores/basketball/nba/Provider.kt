package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.nba


import com.google.gson.annotations.SerializedName

data class Provider(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("priority")
    val priority: Int = 0
)