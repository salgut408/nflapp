package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.nba.TypeX

data class StatusCommX(
    @SerializedName("clock")
    val clock: Double = 0.0,
    @SerializedName("displayClock")
    val displayClock: String = "",
    @SerializedName("period")
    val period: Int = 0,
    @SerializedName("type")
    val type: TypeX = TypeX()
)