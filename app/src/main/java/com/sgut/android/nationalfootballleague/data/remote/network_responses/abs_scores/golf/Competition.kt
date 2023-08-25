package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.golf


import com.google.gson.annotations.SerializedName

data class Competition(
    val competitors: List<Competitor> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("status")
    val status: Status = Status(),
    @SerializedName("uid")
    val uid: String = ""
)