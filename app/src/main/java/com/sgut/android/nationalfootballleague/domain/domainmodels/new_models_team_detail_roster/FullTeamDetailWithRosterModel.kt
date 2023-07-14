package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster

data class FullTeamDetailWithRosterModel(
    val id: String = "",
    val uid: String = "",
    val slug: String = "",
    val location: String = "",
    val name: String = "",
    val nickname: String = "",
    val abbreviation: String = "",
    val displayName: String = "",
    val shortDisplayName: String = "",
    val color: String = "",
    val alternateColor: String = "",
    val logos: List<FullTeamDetailsLogoModel> = listOf(),
    val record: RecordModel = RecordModel(),
    val athletes: List<AthletesRosterModel> = listOf(),
    var franchise: FullTeamDetailsFranchiseModel = FullTeamDetailsFranchiseModel(),
    val nextEvent: List<NextEventModel> = listOf(),
    val standingSummary: String = "",
)
