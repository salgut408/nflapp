package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Format(
    @SerializedName("regulation")
    val regulation: Regulation? = Regulation()
)