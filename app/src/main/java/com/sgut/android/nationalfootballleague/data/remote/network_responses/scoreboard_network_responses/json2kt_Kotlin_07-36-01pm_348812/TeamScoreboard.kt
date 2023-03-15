package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardTeamModel


data class TeamScoreboard(

    @SerializedName("id")
    val id: String = "",
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("color")
    val color: String = "",
    @SerializedName("displayName")
    var displayName: String = "",
    @SerializedName("score")
    val score: Int = 0,
    @SerializedName("shortDisplayName")
    val shortDisplayName: String = "",

    )

fun TeamScoreboard.asDomain(): ScoreboardTeamModel {
    return ScoreboardTeamModel(
        id = id,
        abbreviation = abbreviation,
        name = name,
        logo = logo,
        color = color,
        displayName = displayName,
        score = score,
        shortDisplayName = shortDisplayName
    )
}