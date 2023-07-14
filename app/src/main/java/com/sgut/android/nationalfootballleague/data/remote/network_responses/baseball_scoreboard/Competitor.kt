package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Competitor(
    @SerializedName("errors")
    val errors: Int? = 0,
    @SerializedName("hits")
    val hits: Int? = 0,
    @SerializedName("homeAway")
    val homeAway: String? = "",
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("leaders")
    val leaders: List<Leader>? = listOf(),
    @SerializedName("linescores")
    val linescores: List<Linescore>? = listOf(),
    @SerializedName("order")
    val order: Int? = 0,
    @SerializedName("probables")
    val probables: List<Probable>? = listOf(),
    @SerializedName("records")
    val records: List<Record>? = listOf(),
    @SerializedName("score")
    val score: String? = "",
    @SerializedName("statistics")
    val statistics: List<StatisticX>? = listOf(),
    @SerializedName("team")
    val team: TeamXXX? = TeamXXX(),
    @SerializedName("type")
    val type: String? = "",
    @SerializedName("uid")
    val uid: String? = ""
)