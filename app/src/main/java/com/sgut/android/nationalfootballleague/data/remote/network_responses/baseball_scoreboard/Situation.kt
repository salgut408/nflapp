package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Situation(
    @SerializedName("balls")
    val balls: Int? = 0,
    @SerializedName("batter")
    val batter: Batter? = Batter(),
    @SerializedName("dueUp")
    val dueUp: List<DueUp>? = listOf(),
    @SerializedName("lastPlay")
    val lastPlay: LastPlay? = LastPlay(),
    @SerializedName("onFirst")
    val onFirst: Boolean? = false,
    @SerializedName("onSecond")
    val onSecond: Boolean? = false,
    @SerializedName("onThird")
    val onThird: Boolean? = false,
    @SerializedName("outs")
    val outs: Int? = 0,
    @SerializedName("pitcher")
    val pitcher: Pitcher? = Pitcher(),
    @SerializedName("strikes")
    val strikes: Int? = 0
)