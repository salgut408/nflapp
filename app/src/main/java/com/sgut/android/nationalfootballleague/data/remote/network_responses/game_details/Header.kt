package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Header(

  @SerializedName("id") val id: String? = null,
  @SerializedName("uid") val uid: String? = null,
  @SerializedName("season") val season: GameDetailsSeason? = GameDetailsSeason(),
  @SerializedName("timeValid") val timeValid: Boolean? = null,
  @SerializedName("competitions") val competitions: List<GameDetailsCompetitions> = listOf(),
//  @SerializedName("links"        ) var links        : ArrayList<GameDetailsLinks>        = arrayListOf(),
  @SerializedName("week") val week: Int? = null,
  @SerializedName("league") val league: GameDetailsLeague? = GameDetailsLeague(),
  @SerializedName("gameNote"     ) var gameNote     : String?                 = null


)