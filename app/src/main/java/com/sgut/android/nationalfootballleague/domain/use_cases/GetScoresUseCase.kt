package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASKETBALL
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetScoresUseCase @Inject constructor(
     private val scoreboardRepository: ScoreboardRepository,
     private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    suspend operator fun invoke (sport: String, league: String): ScoreboardModel =
        withContext(defaultDispatcher) {
            if (league == NCAA_BASKETBALL) {
                val scoreboard = scoreboardRepository.getCollegeBasketballScoreboard(sport = sport, league = league, limit = "200")
                return@withContext scoreboard
            }
            val scoreboard = scoreboardRepository.getGeneralScoreboard(sport = sport, league = league)
            return@withContext scoreboard
        }
}