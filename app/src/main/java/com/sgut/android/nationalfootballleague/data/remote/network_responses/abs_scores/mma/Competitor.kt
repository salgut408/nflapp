package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.mma


import com.google.gson.annotations.SerializedName

data class Competitor(
    @SerializedName("athlete")
    val athlete: Athlete = Athlete(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("order")
    val order: Int = 0,
    @SerializedName("type")
    val type: String = "",
    @SerializedName("uid")
    val uid: String = "",
    @SerializedName("winner")
    val winner: Boolean = false
)