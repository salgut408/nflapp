package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

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
    var article: GameDetailsArticle? = GameDetailsArticle(),
    var ticketsInfo: GameDetailsTicketsInfo? = GameDetailsTicketsInfo(),
    var standings: GameDetailsStandings? = GameDetailsStandings(),

    )
