package com.sgut.android.nationalfootballleague.data.domainmodels

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.*

data class GameDetailModel(

    var boxscore: GameDetailsBoxscore? = GameDetailsBoxscore(),
    var format: GameDetailsFormat? = GameDetailsFormat(),
    var gameInfo: GameInfo? = GameInfo(),
    var lastFiveGames: ArrayList<LastFiveGames> = arrayListOf(),
    var leaders: ArrayList<GameDetailsLeaders> = arrayListOf(),
    var injuries: ArrayList<GameDetailsInjuries> = arrayListOf(),
    var broadcasts: ArrayList<GameDetailsBroadcasts> = arrayListOf(),
    var predictor: Predictor? = Predictor(),
    var pickcenter: ArrayList<Pickcenter> = arrayListOf(),
    var againstTheSpread: ArrayList<AgainstTheSpread> = arrayListOf(),
    var odds: ArrayList<Odds> = arrayListOf(),
    var header: Header? = Header(),
    var news: News? = News(),
    var article: GameDetailsArticle? = GameDetailsArticle(),
    var ticketsInfo: GameDetailsTicketsInfo? = GameDetailsTicketsInfo(),
    var standings: GameDetailsStandings? = GameDetailsStandings(),

    )
