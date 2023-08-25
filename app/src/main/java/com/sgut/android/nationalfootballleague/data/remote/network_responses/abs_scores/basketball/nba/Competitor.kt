package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.nba


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.TeamComm

data class Competitor(
    @SerializedName("homeAway")
    val homeAway: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("score")
    val score: String = "",
    @SerializedName("team")
    val team: TeamComm = TeamComm(),
    @SerializedName("uid")
    val uid: String = ""
)