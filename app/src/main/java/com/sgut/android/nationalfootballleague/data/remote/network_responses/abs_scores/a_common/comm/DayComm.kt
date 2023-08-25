package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName

data class DayComm(
    @SerializedName("date")
    val date: String = ""
)