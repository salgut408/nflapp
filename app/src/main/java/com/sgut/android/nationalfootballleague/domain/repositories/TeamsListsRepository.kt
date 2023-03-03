package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsModel

interface TeamsListsRepository {

    suspend fun getFullSportLeagueAndTeamsList(sport: String, league: String): FullTeamsModel


}