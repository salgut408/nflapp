package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.soccer


import com.google.gson.annotations.SerializedName

data class Position(
    @SerializedName("abbreviation")
    val abbreviation: String = ""
)