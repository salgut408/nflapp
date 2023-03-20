package com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details

import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Drives
import com.sgut.android.nationalfootballleague.data.remote.network_responses.game_details.Videos

data class GameDetailsModel(
    val boxscore: GameDetailsBoxscore? = GameDetailsBoxscore(), // needs mod
    val format: GameDetailsFormat? = GameDetailsFormat(), // needs mod
    val gameInfo: GameInfo? = GameInfo(), // needs mod
    val lastFiveGames: List<LastFiveGames> = listOf(), // needs mod
    val leaders: List<GameDetailsLeaders> = listOf(), // needs mod
    val injuries: List<GameDetailsInjuries> = listOf(), // needs mod
    val broadcasts: List<GameDetailsBroadcasts> = listOf(), // needs mod
    val predictor: Predictor? = Predictor(), // needs mod
    val pickcenter: List<Pickcenter> = listOf(), // needs mod
    val againstTheSpread: List<AgainstTheSpread> = listOf(), // needs mod
    val odds: List<Odds> = listOf(), // needs mod
    val header: Header? = Header(), // needs mod
    val news: News? = News(), // needs mod
    val singleGameArticle: GameDetailsArticle? = GameDetailsArticle(),  // needs mod
    val ticketsInfo: GameDetailsTicketsInfo? = GameDetailsTicketsInfo(), // needs mod
    val standings: GameDetailsStandings? = GameDetailsStandings(), // needs mod
    val drives: Drives? = Drives(), // needs mod
    val winprobability: List<Winprobability> = listOf(), // needs mod
    val scoringPlays: List<ScoringPlays> = listOf(), // needs mod
    val videos: List<Videos> = listOf(),// needs mod
    val plays: List<NetworkPlays> = listOf(), // needs mod
)
