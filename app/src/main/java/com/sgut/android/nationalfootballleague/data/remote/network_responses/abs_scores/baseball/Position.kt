package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class Position(
    @SerializedName("abbreviation")
    val abbreviation: String = ""
)