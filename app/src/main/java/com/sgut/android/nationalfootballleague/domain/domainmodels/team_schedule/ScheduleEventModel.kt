package com.sgut.android.nationalfootballleague.domain.domainmodels.team_schedule

data class ScheduleEventModel(
    val competitions: List<ScheduleCompetitionModel> = listOf(),
    val date: String = "",
    val id: String = "",
    val name: String = "",
    val shortName: String = "",
    val seasonType: ScheduleSeasonTypeModel = ScheduleSeasonTypeModel(),

    )