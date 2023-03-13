package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel

interface TeamDetailsRepository {

    suspend fun getSpecificTeam(
        sport: String,
        league: String,
        team: String,
    ): FullTeamDetailWithRosterModel

}