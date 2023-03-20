package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

data class GameDetailsTeamInfoModel(
    val id: String = "",
    val uid: String = "",
    val location: String = "",
    val name: String = "",
    val abbreviation: String = "",
    val displayName: String? = null,
    val color: String = "",
    val alternateColor: String = "",
    val logos: DomainLogoModel = DomainLogoModel(),
    val logo: String = "",
    val record: List<GameDetailsRecordModel> = listOf(),
)
