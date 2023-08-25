package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.college


import com.google.gson.annotations.SerializedName

data class Groups(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("isConference")
    val isConference: Boolean = false,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortName")
    val shortName: String = ""
)