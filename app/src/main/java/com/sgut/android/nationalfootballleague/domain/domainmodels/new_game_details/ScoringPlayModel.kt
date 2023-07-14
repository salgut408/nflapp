package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class ScoringPlayModel(
    val id: String = "",
    val type: GameDetailsTypeModel? = GameDetailsTypeModel(),
    val text: String = "",
    val awayScore: Int = 0,
    val homeScore: Int = 0,
    val period: Int = 0,
    val clock: String = "" ,
    val team: GameDetailsTeamInfoModel? = GameDetailsTeamInfoModel(),
    val scoringType: ScoringTypeModel? = ScoringTypeModel(),
)
