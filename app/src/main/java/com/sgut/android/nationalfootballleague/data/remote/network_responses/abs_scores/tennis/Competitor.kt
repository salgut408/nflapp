package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName

data class Competitor(
    @SerializedName("athlete")
    val athlete: Athlete = Athlete(),
    @SerializedName("curatedRank")
    val curatedRank: CuratedRank = CuratedRank(),
    @SerializedName("homeAway")
    val homeAway: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("linescores")
    val linescores: List<Linescore> = listOf(),
    @SerializedName("order")
    val order: Int = 0,
    @SerializedName("statistics")
    val statistics: List<Any> = listOf(),
    @SerializedName("type")
    val type: String = "",
    @SerializedName("uid")
    val uid: String = "",
    @SerializedName("winner")
    val winner: Boolean = false
)