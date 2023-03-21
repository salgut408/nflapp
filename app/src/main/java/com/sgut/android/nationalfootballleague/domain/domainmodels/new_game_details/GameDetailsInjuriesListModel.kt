package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.GameDetailsType

data class GameDetailsInjuriesListModel(
    val team: InjTeamModel = InjTeamModel(),
    val injuries: List<InjuriesItemModel> = listOf(),

    )

data class InjTeamModel(
    val id: String = "",
    val displayName: String = "",
    val logo: String = ""
)

data class InjuriesItemModel(
    val status: String = "",
    val date: String = "",
    val athlete: GameDetailsAthleteDetailsModel = GameDetailsAthleteDetailsModel(),
    val type: GameDetailsType = GameDetailsType(),

    )
