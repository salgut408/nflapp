package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.ScoreboardData
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import com.sgut.android.nationalfootballleague.utils.printToLog
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class NewScoresUseCase @Inject constructor(
    private val scoreboardRepository: ScoreboardRepository,
    private val ioDispatcher: CoroutineDispatcher,
) {
    suspend operator fun invoke(sport: String, league: String): ScoreboardData =
        withContext(ioDispatcher) {
            val scores = scoreboardRepository.getAbstractScoreBoard(sport, league)
            scores.printToLog("ABSTRACTSCORE_USECASE")
            return@withContext scores
        }
}
