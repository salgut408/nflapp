package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class TypeX(
    @SerializedName("abbreviation")
    val abbreviation: String? = "",
    @SerializedName("alternativeText")
    val alternativeText: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("text")
    val text: String? = "",
    @SerializedName("type")
    val type: String? = ""
)