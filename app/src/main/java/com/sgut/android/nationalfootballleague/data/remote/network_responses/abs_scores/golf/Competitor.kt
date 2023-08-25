package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.AthleteGolf

data class Competitor(
    @SerializedName("athlete")
    val athlete: AthleteGolf = AthleteGolf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("score")
    val score: String = "",
    @SerializedName("type")
    val type: String = "",
    @SerializedName("uid")
    val uid: String = ""
)