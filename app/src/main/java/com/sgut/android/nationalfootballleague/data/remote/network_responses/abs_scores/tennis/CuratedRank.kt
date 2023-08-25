package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class CuratedRank(
    @SerializedName("current")
    val current: Int = 0
)