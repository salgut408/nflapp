package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.FullTeamsListsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.LeagueModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.SportModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel

interface TeamsListsRepository {

    suspend fun getFullSportLeagueAndTeamsList(sport: String, league: String): FullTeamsListsModel
    suspend fun getSport(sport: String, league: String): SportModel
    suspend fun getLeague(sport: String, league: String): LeagueModel
    suspend fun getTeamsList(sport: String, league: String): List<TeamModel>
    suspend fun storeTeamsInSportsDatabaseFullInfoTable(teams: List<TeamModel>, sport: String, league: String, leagueAbrv: String)



}