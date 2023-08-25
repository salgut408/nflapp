package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.college


import com.google.gson.annotations.SerializedName

data class Headline(
    @SerializedName("description")
    val description: String = "",
    @SerializedName("shortLinkText")
    val shortLinkText: String = "",
    @SerializedName("type")
    val type: String = ""
)