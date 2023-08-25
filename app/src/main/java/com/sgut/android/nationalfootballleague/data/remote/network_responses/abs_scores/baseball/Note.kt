package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball


import com.google.gson.annotations.SerializedName

data class Note(
    @SerializedName("headline")
    val headline: String = "",
    @SerializedName("type")
    val type: String = ""
)