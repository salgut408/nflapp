package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsLeagueModel


data class GameDetailsLeague(

    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("name")
    val name: String = "",
    @SerializedName("abbreviation")
    val abbreviation: String = "",

)

fun GameDetailsLeague.asDomain(): GameDetailsLeagueModel {
    return GameDetailsLeagueModel(
        id = id ?: 0,
        description = description,
        name = name,
        abbreviation = abbreviation
    )
}