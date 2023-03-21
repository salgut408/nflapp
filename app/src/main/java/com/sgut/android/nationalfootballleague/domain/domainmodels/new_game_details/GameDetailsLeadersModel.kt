package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsLeadersModel(
    val team: GameDetailsTeamInfoModel,
    val leaders: List<GameLeadersModel>
)

data class GameLeadersModel(
    val name: String = "",
    val displayName: String = "",
    val leadersAthlete: List<AthleteLeaderModel> = listOf(),
    )
data class AthleteLeaderModel(
    val displayValue: String = "",
    val athlete: GameDetailsAthleteDetailsModel = GameDetailsAthleteDetailsModel(),

    )