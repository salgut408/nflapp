package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailResponse (

  @SerializedName("boxscore"         ) var boxscore         : GameDetailsBoxscore?                   = GameDetailsBoxscore(),
  @SerializedName("format"           ) var format           : GameDetailsFormat?                     = GameDetailsFormat(),
  @SerializedName("gameInfo"         ) var gameInfo         : GameInfo?                   = GameInfo(),
  @SerializedName("lastFiveGames"    ) var lastFiveGames    : ArrayList<LastFiveGames>    = arrayListOf(),
  @SerializedName("leaders"          ) var leaders          : ArrayList<GameDetailsLeaders>          = arrayListOf(),
  @SerializedName("injuries"         ) var injuries         : ArrayList<GameDetailsInjuries>         = arrayListOf(),
  @SerializedName("broadcasts"       ) var broadcasts       : ArrayList<GameDetailsBroadcasts>       = arrayListOf(),
  @SerializedName("predictor"        ) var predictor        : Predictor?                  = Predictor(),
  @SerializedName("pickcenter"       ) var pickcenter       : ArrayList<Pickcenter>       = arrayListOf(),
  @SerializedName("againstTheSpread" ) var againstTheSpread : ArrayList<AgainstTheSpread> = arrayListOf(),
  @SerializedName("odds"             ) var odds             : ArrayList<Odds>             = arrayListOf(),
  @SerializedName("header"           ) var header           : Header?                     = Header(),
  @SerializedName("news"             ) var news             : News?                       = News(),
  @SerializedName("article"          ) var article          : GameDetailsArticle?                    = GameDetailsArticle(),
  @SerializedName("ticketsInfo"      ) var ticketsInfo      : GameDetailsTicketsInfo?                = GameDetailsTicketsInfo(),
  @SerializedName("standings"        ) var standings        : GameDetailsStandings?                  = GameDetailsStandings()

)