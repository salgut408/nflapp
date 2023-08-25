package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.hockey


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("competitors")
    val competitors: List<Competitor> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("status")
    val status: StatusX = StatusX(),
    @SerializedName("uid")
    val uid: String = "",
)