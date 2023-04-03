package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsModel
import com.sgut.android.nationalfootballleague.domain.repositories.GameDetailsRepository
import com.sgut.android.nationalfootballleague.domain.repositories.TeamDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


//game details and full team information - > Athletes map
class PlayersMapUseCase @Inject constructor(
    private val gameDetailsRepository: GameDetailsRepository,
    private val teamDetailsRepository: TeamDetailsRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default

)  {
    suspend fun getGameDetails(sport: String, league: String, event: String): GameDetailsModel = withContext(defaultDispatcher){
        val details = gameDetailsRepository.getGameDetails(sport, league, event)
        details
    }

    suspend fun loadPlayerMap(sport: String, league: String, team: String): Map<String, GameDetailsAthleteDetailsModel> = withContext(defaultDispatcher){
        val teamMap = teamDetailsRepository.getSpecificTeamRosterInGameDetails(sport, league, team).associate { it.id to it }
        teamMap
    }


}