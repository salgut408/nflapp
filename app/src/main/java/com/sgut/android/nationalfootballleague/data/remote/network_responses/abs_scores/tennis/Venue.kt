package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class Venue(
    @SerializedName("court")
    val court: String = "",
    @SerializedName("fullName")
    val fullName: String = ""
)