package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.GroupingTennisModel

data class Grouping(
    @SerializedName("competitions")
    val competitions: List<Competition> = listOf(),
    @SerializedName("grouping")
    val grouping: GroupingX = GroupingX()
)

fun Grouping.asDomain(): GroupingTennisModel {
    return GroupingTennisModel(
        competitions = competitions.map { it.asDomain() },
        grouping = grouping.asDomain()
    )
}