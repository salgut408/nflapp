package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.basketball.college


import com.google.gson.annotations.SerializedName

data class Competitor(
    @SerializedName("curatedRank")
    val curatedRank: CuratedRank = CuratedRank(),
    @SerializedName("homeAway")
    val homeAway: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("leaders")
    val leaders: List<Leader> = listOf(),
    @SerializedName("linescores")
    val linescores: List<Linescore> = listOf(),
    @SerializedName("order")
    val order: Int = 0,
    @SerializedName("records")
    val records: List<Record> = listOf(),
    @SerializedName("score")
    val score: String = "",
    @SerializedName("statistics")
    val statistics: List<Statistic> = listOf(),
    @SerializedName("team")
    val team: TeamXX = TeamXX(),
    @SerializedName("type")
    val type: String = "",
    @SerializedName("uid")
    val uid: String = "",
    @SerializedName("winner")
    val winner: Boolean = false
)