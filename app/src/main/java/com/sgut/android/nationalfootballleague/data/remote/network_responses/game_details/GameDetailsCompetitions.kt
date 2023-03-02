package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class GameDetailsCompetitions (

  @SerializedName("id"                    ) var id                    : String?                = null,
  @SerializedName("uid"                   ) var uid                   : String?                = null,
  @SerializedName("date"                  ) var date                  : String?                = null,
  @SerializedName("neutralSite"           ) var neutralSite           : Boolean?               = null,
  @SerializedName("conferenceCompetition" ) var conferenceCompetition : Boolean?               = null,
  @SerializedName("boxscoreAvailable"     ) var boxscoreAvailable     : Boolean?               = null,
  @SerializedName("commentaryAvailable"   ) var commentaryAvailable   : Boolean?               = null,
  @SerializedName("liveAvailable"         ) var liveAvailable         : Boolean?               = null,
  @SerializedName("onWatchESPN"           ) var onWatchESPN           : Boolean?               = null,
  @SerializedName("recent"                ) var recent                : Boolean?               = null,
  @SerializedName("boxscoreSource"        ) var boxscoreSource        : String?                = null,
  @SerializedName("playByPlaySource"      ) var playByPlaySource      : String?                = null,
  @SerializedName("competitors"           ) var competitors           : List<GameDetailsCompetitors> = listOf(),
  @SerializedName("status"                ) var status                : GameDetailsStatus?                = GameDetailsStatus(),
  @SerializedName("broadcasts"            ) var broadcasts            : ArrayList<GameDetailsBroadcasts>  = arrayListOf()

)