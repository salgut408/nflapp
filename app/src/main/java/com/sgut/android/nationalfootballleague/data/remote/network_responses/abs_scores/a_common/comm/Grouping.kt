package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.TennisCompetition

data class Grouping(
    @SerializedName("competitions")
    val competitions: List<TennisCompetition> = listOf(),
    @SerializedName("grouping")
    val grouping: GroupingX = GroupingX()
)