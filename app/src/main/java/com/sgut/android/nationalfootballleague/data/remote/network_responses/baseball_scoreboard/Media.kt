package com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard


import com.google.gson.annotations.SerializedName

data class Media(
    @SerializedName("shortName")
    val shortName: String? = ""
)