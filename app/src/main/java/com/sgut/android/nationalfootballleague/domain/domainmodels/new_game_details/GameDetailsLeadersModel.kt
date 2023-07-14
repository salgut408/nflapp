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

data class GameLeadersModel4(
    val name: String = "",
    val displayName: String = "",
    val leadersAthlete: List<AthleteLeaderModel4> = listOf(),
)


data class AthleteLeaderModel(
    val displayValue: String = "",
    val athlete: GameDetailsAthleteDetailsModel = GameDetailsAthleteDetailsModel(),

    )

data class AthleteLeaderModel4(
    val displayValue: String = "",
    val athlete: GameDetailsAthleteDetailsModel4 = GameDetailsAthleteDetailsModel4(),

    )