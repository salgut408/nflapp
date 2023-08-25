package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.mma


import com.google.gson.annotations.SerializedName

data class Athlete(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("flag")
    val flag: Flag = Flag(),
    @SerializedName("fullName")
    val fullName: String = "",
    @SerializedName("shortName")
    val shortName: String = ""
)