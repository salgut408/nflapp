package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


//game details and full team information - > Athletes map
class PlayersMapUseCase @Inject constructor(
    private val teamDetailsRepository: TeamDetailsRepository,
    private val defaultDispatcher: CoroutineDispatcher ,
    ) {
    val map: MutableMap<String, GameDetailsAthleteDetailsModel> = mutableMapOf()

    suspend operator fun invoke(
        sport: String,
        league: String,
        teams: List<String>,
    ): Map<String, GameDetailsAthleteDetailsModel> = withContext(defaultDispatcher) {

        teams.forEach { team ->
            map += teamDetailsRepository.getSpecificTeamRosterInGameDetails(sport, league, team).associate {
                it.id to it
            }.toMutableMap()
        }

        return@withContext map
    }

}