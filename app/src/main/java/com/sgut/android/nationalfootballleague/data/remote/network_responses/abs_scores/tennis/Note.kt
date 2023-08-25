package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class Note(
    @SerializedName("text")
    val text: String = "",
    @SerializedName("type")
    val type: String = ""
)