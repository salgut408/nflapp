package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.racing


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("status")
    val status: StatusX = StatusX(),
    @SerializedName("uid")
    val uid: String = ""
)