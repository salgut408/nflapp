package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard.Situation

data class Competition(
    @SerializedName("competitors")
    val competitors: List<Competitor>? = listOf(),
    @SerializedName("id")
    val id: String? = "",
    @SerializedName("outsText")
    val outsText: String? = "",
    @SerializedName("situation")
    val situation: Situation? = Situation(),
    @SerializedName("startDate")
    val startDate: String? = "",
    @SerializedName("status")
    val status: Status? = Status(),
    @SerializedName("uid")
    val uid: String? = "",

)