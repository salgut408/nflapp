package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster

data class NextEventModel(
    val id: String = "",
    val date: String = "",
    val name: String = "",
    val shortName: String = "",
    val season: SeasonModel = SeasonModel(),
    val seasonType: SeasonTypeModel = SeasonTypeModel(),
    val week: WeekModel? = WeekModel(),
    val competitions: List<CompetitionsEventModel> = listOf()
)
