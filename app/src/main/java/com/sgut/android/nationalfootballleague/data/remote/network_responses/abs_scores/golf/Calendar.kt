package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class Calendar(
    @SerializedName("endDate")
    val endDate: String = "",

    @SerializedName("id")
    val id: String = "",
    @SerializedName("label")
    val label: String = "",
    @SerializedName("startDate")
    val startDate: String = ""
)