package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.hockey


import com.google.gson.annotations.SerializedName

data class Regulation(
    @SerializedName("periods")
    val periods: Int = 0
)