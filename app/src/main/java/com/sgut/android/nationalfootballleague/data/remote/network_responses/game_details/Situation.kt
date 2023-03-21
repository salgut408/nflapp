package com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details

import com.google.gson.annotations.SerializedName


data class Situation(

    @SerializedName("lastPlay")
    val lastPlay: LastPlay? = LastPlay(),
    @SerializedName("balls")
    val balls: Int? = null,
    @SerializedName("strikes")
    val strikes: Int? = null,
    @SerializedName("outs")
    val outs: Int? = null,
    @SerializedName("pitcher")
    val pitcher: Pitcher? = Pitcher(),
    @SerializedName("batter")
    val batter: Batter? = Batter(),
)

data class LastPlay(

    @SerializedName("id")
    val id: String? = null,

    )

data class Pitcher(
    @SerializedName("playerId")
    val playerId: Int? = null,
    )

data class Batter(
    @SerializedName("playerId")
    val playerId: Int? = null,

    )
