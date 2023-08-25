package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.racing


import com.google.gson.annotations.SerializedName

data class Market(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("type")
    val type: String = ""
)