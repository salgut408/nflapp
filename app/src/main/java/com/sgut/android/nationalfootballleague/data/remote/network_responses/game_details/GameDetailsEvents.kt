package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsEvents (
  @SerializedName("id" ) var id : String = "",
//  @SerializedName("links" ) var links : List<EventLinks> = listOf(),
  @SerializedName("atVs" ) var atVs : String = "",
  @SerializedName("gameDate" ) var gameDate : String = "",
  @SerializedName("score" ) var score : String = "",
  @SerializedName("homeTeamScore" ) var homeTeamScore : String = "",
  @SerializedName("awayTeamScore" ) var awayTeamScore : String = "",
  @SerializedName("gameResult" ) var gameResult : String = "",
  @SerializedName("opponent" ) var opponent : Opponent = Opponent(),
  @SerializedName("opponentLogo" ) var opponentLogo : String = "",
  @SerializedName("leagueName" ) var leagueName : String = "",
  @SerializedName("leagueAbbreviation" ) var leagueAbbreviation : String = "",





  )

data class Opponent(
  @SerializedName("id" ) var id : String = "",
  @SerializedName("displayName" ) var displayName : String = "",
  @SerializedName("abbreviation" ) var abbreviation : String = "",
  @SerializedName("logo" ) var logo : String = "",


  )

data class EventLinks(
  @SerializedName("href" ) var href : String = "",
  @SerializedName("text" ) var text : String = "",
  )