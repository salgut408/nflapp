package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class AgainstTheSpreadModel(
    val team: GameDetailsTeamInfoModel? = GameDetailsTeamInfoModel(),
    val records: ArrayList<String> = arrayListOf(),
)
