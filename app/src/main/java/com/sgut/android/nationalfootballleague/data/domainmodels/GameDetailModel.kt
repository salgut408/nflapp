package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*
import com.sgut.android.nationalfootballleague.data.remote.responses.game_details.Drives
import com.sgut.android.nationalfootballleague.data.remote.responses.game_details.Videos

data class GameDetailModel(

    var boxscore: GameDetailsBoxscore? = GameDetailsBoxscore(),
    var format: GameDetailsFormat? = GameDetailsFormat(),
    var gameInfo: GameInfo? = GameInfo(),
    var lastFiveGames: List<LastFiveGames> = listOf(),
    var leaders: List<GameDetailsLeaders> = listOf(),
    var injuries: List<GameDetailsInjuries> = listOf(),
    var broadcasts: List<GameDetailsBroadcasts> = listOf(),
    var predictor: Predictor? = Predictor(),
    var pickcenter: List<Pickcenter> = listOf(),
    var againstTheSpread: List<AgainstTheSpread> = listOf(),
    var odds: List<Odds> = listOf(),
    var header: Header? = Header(),
    var news: News? = News(),
    var singleArticle: GameDetailsArticle? = GameDetailsArticle(),
    var ticketsInfo: GameDetailsTicketsInfo? = GameDetailsTicketsInfo(),
    var standings: GameDetailsStandings? = GameDetailsStandings(),
    var drives: Drives? = Drives(),
    var winprobability: List<Winprobability> = listOf(),
    var scoringPlays: List<ScoringPlays> = listOf(),
    var videos: List<Videos> = listOf(),

    )
