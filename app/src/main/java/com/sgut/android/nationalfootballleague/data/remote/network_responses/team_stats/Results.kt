package com.sgut.android.nationalfootballleague.data.remote.network_responses.team_stats


import com.google.gson.annotations.SerializedName

data class Results(
    @SerializedName("splits")
    val splits: List<Split> = listOf(),
    @SerializedName("stats")
    val stats: Stats = Stats()
)