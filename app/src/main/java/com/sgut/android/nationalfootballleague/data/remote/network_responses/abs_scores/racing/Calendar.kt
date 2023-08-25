package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.racing


import com.google.gson.annotations.SerializedName

data class Calendar(
    @SerializedName("endDate")
    val endDate: String = "",

    @SerializedName("label")
    val label: String = "",
    @SerializedName("startDate")
    val startDate: String = ""
)