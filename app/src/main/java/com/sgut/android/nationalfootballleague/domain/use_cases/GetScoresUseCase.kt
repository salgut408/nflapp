package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetScoresUseCase @Inject constructor(
     private val scoreboardRepository: ScoreboardRepository,
     private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke (sport: String, league: String): ScoreboardModel =
        withContext(defaultDispatcher) {
            val scoreboard = scoreboardRepository.getGeneralScoreboard(sport = sport, league = league)
            return@withContext scoreboard
        }
}