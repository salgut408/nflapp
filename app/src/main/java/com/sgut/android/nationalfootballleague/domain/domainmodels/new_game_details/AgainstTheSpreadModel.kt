package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class AgainstTheSpreadModel(
    val team: GameDetailsTeamInfoModel? = GameDetailsTeamInfoModel(),
    val records: ArrayList<String> = arrayListOf(),
)

data class ProbablesModel(
    val name: String = "",
    val displayName: String = "",
    val shortDisplayName:String = "",
    val abbreviation: String = "",
    val playerId: Int = 0,
    val athlete: GameDetailsAthleteDetailsModel? = GameDetailsAthleteDetailsModel(),
)