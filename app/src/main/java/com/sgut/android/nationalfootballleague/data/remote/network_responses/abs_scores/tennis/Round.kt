package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class Round(
    @SerializedName("displayName")
    val displayName: String = "",
    @SerializedName("id")
    val id: String = ""
)