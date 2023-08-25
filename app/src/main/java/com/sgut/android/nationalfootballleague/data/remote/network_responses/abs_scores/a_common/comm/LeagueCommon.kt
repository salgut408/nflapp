package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName

data class LeagueCommon(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    val id: String = "",
    @SerializedName("logos")
    val logos: List<LogoComm> = listOf(),
    @SerializedName("name")
    val name: String = "",
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("uid")
    val uid: String = ""
)