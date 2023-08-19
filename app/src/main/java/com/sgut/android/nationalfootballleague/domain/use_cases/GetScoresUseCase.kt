package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.DefaultScoreboardModel
import com.sgut.android.nationalfootballleague.domain.repositories.ScoreboardRepository
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASKETBALL
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetScoresUseCase @Inject constructor(
     private val scoreboardRepository: ScoreboardRepository,
     private val ioDispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke (sport: String, league: String): DefaultScoreboardModel =
        withContext(ioDispatcher) {
            if (league == NCAA_BASKETBALL) {
                val scoreboard = scoreboardRepository.getCollegeBasketballScoreboard(sport = sport, league = league, limit = "200")
                return@withContext scoreboard
            }
//            else if (league == ATP) { TODO  use the interfaces to return basics eventually
//                val scoreBoard = scoreboardRepository.getTennisScoreBoard(sport = sport, league = league)
//                return@withContext scoreBoard
//            }
            val scoreboard = scoreboardRepository.getGeneralScoreboard(sport = sport, league = league)
            return@withContext scoreboard
        }
}


sealed class RepoResult<out T : Any> {
    data class Success<out T: Any>(val data: T): RepoResult<T>()
    data class Error(val message: String): RepoResult<Nothing>()
}