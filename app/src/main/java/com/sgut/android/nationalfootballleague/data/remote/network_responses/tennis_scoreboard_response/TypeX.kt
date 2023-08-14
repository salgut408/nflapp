package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName

data class TypeX(
    @SerializedName("id")
    val id: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("text")
    val text: String = ""
)