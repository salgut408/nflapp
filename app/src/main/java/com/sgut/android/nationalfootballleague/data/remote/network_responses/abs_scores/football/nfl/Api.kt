package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.football.nfl


import com.google.gson.annotations.SerializedName

data class Api(
    @SerializedName("artwork")
    val artwork: Artwork = Artwork(),
    @SerializedName("self")
    val self: Self = Self()
)