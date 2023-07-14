package com.sgut.android.nationalfootballleague.domain.use_cases

import com.sgut.android.nationalfootballleague.domain.repositories.GameDetailsRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetBaseballSituationUseCase @Inject constructor(
    private val gameDetailsRepository: GameDetailsRepository,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) {
    suspend operator fun invoke(sport: String, league: String, event: String){
        withContext(defaultDispatcher) {
            val situation = gameDetailsRepository.getGameDetails(sport, league, event).baseballSituation
            return@withContext situation
        }
    }
}