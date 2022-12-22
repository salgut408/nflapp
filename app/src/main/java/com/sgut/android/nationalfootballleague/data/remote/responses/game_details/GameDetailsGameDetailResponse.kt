package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.responses.game_details.Drives
import com.sgut.android.nationalfootballleague.data.remote.responses.game_details.Videos


data class GameDetailResponse (

  @SerializedName("boxscore"         ) var boxscore         : GameDetailsBoxscore?                   = GameDetailsBoxscore(),
  @SerializedName("format"           ) var format           : GameDetailsFormat?                     = GameDetailsFormat(),
  @SerializedName("gameInfo"         ) var gameInfo         : GameInfo?                   = GameInfo(),
  @SerializedName("lastFiveGames"    ) var lastFiveGames    : List<LastFiveGames>    = listOf(),
  @SerializedName("leaders"          ) var leaders          : List<GameDetailsLeaders>          = listOf(),
  @SerializedName("injuries"         ) var injuries         : List<GameDetailsInjuries>         = listOf(),
  @SerializedName("broadcasts"       ) var broadcasts       : List<GameDetailsBroadcasts>       = listOf(),
  @SerializedName("predictor"        ) var predictor        : Predictor?                  = Predictor(),
  @SerializedName("pickcenter"       ) var pickcenter       : List<Pickcenter>       = listOf(),
  @SerializedName("againstTheSpread" ) var againstTheSpread : List<AgainstTheSpread> = listOf(),
  @SerializedName("odds"             ) var odds             : List<Odds>             = listOf(),
  @SerializedName("header"           ) var header           : Header?                     = Header(),
  @SerializedName("news"             ) var news             : News?                       = News(),
  @SerializedName("article"          ) var singleGameArticle          : GameDetailsArticle?                    = GameDetailsArticle(),
  @SerializedName("ticketsInfo"      ) var ticketsInfo      : GameDetailsTicketsInfo?                = GameDetailsTicketsInfo(),
  @SerializedName("standings"        ) var standings        : GameDetailsStandings?                  = GameDetailsStandings(),
  @SerializedName("drives"           ) var drives           : Drives?                     = Drives(),
  @SerializedName("winprobability"   ) var winprobability   : List<Winprobability>   = listOf(),
  @SerializedName("scoringPlays"     ) var scoringPlays     : List<ScoringPlays>     = listOf(),
  @SerializedName("videos"           ) var videos           : List<Videos>           = listOf(),




  )