package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.college


import com.google.gson.annotations.SerializedName

data class Regulation(
    @SerializedName("periods")
    val periods: Int = 0
)