package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.nba


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.StatusCommX

data class Competition(
    @SerializedName("competitors")
    val competitors: List<Competitor> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("odds")
    val odds: List<Odd> = listOf(),
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("status")
    val status: StatusCommX = StatusCommX(),
    @SerializedName("uid")
    val uid: String = "",

)