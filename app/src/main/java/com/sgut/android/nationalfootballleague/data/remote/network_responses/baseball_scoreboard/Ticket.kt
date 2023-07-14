package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Ticket(
    @SerializedName("links")
    val links: List<LinkXXXXXXXX>? = listOf(),
    @SerializedName("numberAvailable")
    val numberAvailable: Int? = 0,
    @SerializedName("summary")
    val summary: String? = ""
)