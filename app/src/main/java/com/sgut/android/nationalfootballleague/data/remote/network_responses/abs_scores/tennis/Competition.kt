package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class Competition(
    @SerializedName("competitors")
    val competitors: List<Competitor> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("major")
    val major: Boolean = false,
    @SerializedName("startDate")
    val startDate: String = "",
    @SerializedName("status")
    val status: Status = Status(),
    @SerializedName("uid")
    val uid: String = "",

)