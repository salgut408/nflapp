package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.tennis


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.Grouping

data class Event(
    @SerializedName("groupings")
    val groupings: List<Grouping> = listOf(),
    @SerializedName("id")
    val id: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("shortName")
    val shortName: String = "",
    @SerializedName("uid")
    val uid: String = "",
)