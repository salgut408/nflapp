package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class AthleteX(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("headshot")
    val headshot: String = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = ""
)