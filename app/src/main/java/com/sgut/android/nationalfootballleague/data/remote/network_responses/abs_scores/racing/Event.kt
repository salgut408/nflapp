package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.racing


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.Circuit

data class Event(
    @SerializedName("circuit")
    val circuit: Circuit = Circuit(),
    @SerializedName("competitions")
    val competitions: List<Competition> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("uid")
    val uid: String = ""
)