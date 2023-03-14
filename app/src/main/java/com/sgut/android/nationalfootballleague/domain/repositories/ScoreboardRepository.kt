package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.domain.domainmodels.ScoreboardResponseEventModel

interface ScoreboardRepository {

    suspend fun getGeneralScoreboard(
        sport: String,
        league: String,
    ): ScoreboardResponseEventModel

    suspend fun getGeneralScoreboardByDate(
        sport: String,
        league: String,
        date: String
    ): ScoreboardResponseEventModel

}