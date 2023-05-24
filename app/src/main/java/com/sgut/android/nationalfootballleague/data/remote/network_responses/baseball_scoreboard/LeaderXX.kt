package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class LeaderXX(
    @SerializedName("abbreviation")
    val abbreviation: String? = "",
    @SerializedName("displayName")
    val displayName: String? = "",
    @SerializedName("leaders")
    val leaders: List<LeaderXXX>? = listOf(),
    @SerializedName("name")
    val name: String? = "",
    @SerializedName("shortDisplayName")
    val shortDisplayName: String? = ""
)