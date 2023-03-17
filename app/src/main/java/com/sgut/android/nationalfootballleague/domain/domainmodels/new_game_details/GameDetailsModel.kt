package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Drives
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Videos

data class GameDetailsModel(
    val boxscore: GameDetailsBoxscore? = GameDetailsBoxscore(),
    val format: GameDetailsFormat? = GameDetailsFormat(),
    val gameInfo: GameInfo? = GameInfo(),
    val lastFiveGames: List<LastFiveGames> = listOf(),
    val leaders: List<GameDetailsLeaders> = listOf(),
    val injuries: List<GameDetailsInjuries> = listOf(),
    val broadcasts: List<GameDetailsBroadcasts> = listOf(),
    val predictor: Predictor? = Predictor(),
    val pickcenter: List<Pickcenter> = listOf(),
    val againstTheSpread: List<AgainstTheSpread> = listOf(),
    val odds: List<Odds> = listOf(),
    val header: Header? = Header(),
    val news: News? = News(),
    val singleGameArticle: GameDetailsArticle? = GameDetailsArticle(),
    val ticketsInfo: GameDetailsTicketsInfo? = GameDetailsTicketsInfo(),
    val standings: GameDetailsStandings? = GameDetailsStandings(),
    val drives: Drives? = Drives(),
    val winprobability: List<Winprobability> = listOf(),
    val scoringPlays: List<ScoringPlays> = listOf(),
    val videos: List<Videos> = listOf(),
    val plays: List<NetworkPlays> = listOf(),
)
