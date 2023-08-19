package com.sgut.android.nationalfootballleague.domain.repositories

import com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard.BaseballScoreBoardNetwork
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.DefaultScoreboardModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.TennisScoreboardModel

interface ScoreboardRepository {

    suspend fun getGeneralScoreboard(
        sport: String,
        league: String,
    ): DefaultScoreboardModel

    suspend fun getGeneralScoreboardByDate(
        sport: String,
        league: String,
        date: String
    ): DefaultScoreboardModel

    suspend fun getCollegeBasketballScoreboard(
        sport: String,
        league: String,
        limit: String
    ): DefaultScoreboardModel

    suspend fun getBaseballScoreboard(
        sport: String,
        league: String,
//        TODO MAKE MODEL
    ): BaseballScoreBoardNetwork

    suspend fun getTennisScoreBoard(
        sport: String,
        league: String
    ): TennisScoreboardModel



}