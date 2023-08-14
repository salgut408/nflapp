package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard.BaseballScoreBoardNetwork
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardModel

interface ScoreboardRepository {

    suspend fun getGeneralScoreboard(
        sport: String,
        league: String,
    ): ScoreboardModel

    suspend fun getGeneralScoreboardByDate(
        sport: String,
        league: String,
        date: String
    ): ScoreboardModel

    suspend fun getCollegeBasketballScoreboard(
        sport: String,
        league: String,
        limit: String
    ): ScoreboardModel

    suspend fun getBaseballScoreboard(
        sport: String,
        league: String,
//        TODO MAKE MODEL
    ): BaseballScoreBoardNetwork



}