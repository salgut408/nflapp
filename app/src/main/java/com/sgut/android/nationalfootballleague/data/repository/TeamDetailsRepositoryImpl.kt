package com.sgut.android.nationalfootballleague.data.repository

import com.sgut.android.nationalfootballleague.asDomain
import com.sgut.android.nationalfootballleague.data.db.SportsDataBase
import com.sgut.android.nationalfootballleague.data.remote.api.EspnApi
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamDetailsRepository
import javax.inject.Inject

class TeamDetailsRepositoryImpl @Inject constructor(
    val espnApi: EspnApi,
    val sportsDataBase: SportsDataBase
): TeamDetailsRepository{

    override suspend fun getSpecificTeam(
        sport: String,
        league: String,
        team: String,
    ): FullTeamDetailWithRosterModel {
        val result = espnApi.getSpecificTeam(sport, league, team).body()?.fullTeam
        return result?.asDomain() ?: FullTeamDetailWithRosterModel()
    }
}