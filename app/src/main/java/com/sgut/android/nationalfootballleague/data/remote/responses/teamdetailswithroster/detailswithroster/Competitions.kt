package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Competitions3 (

  @SerializedName("id"                ) var id                : String?                = null,
  @SerializedName("date"              ) var date              : String?                = null,
  @SerializedName("attendance"        ) var attendance        : Int?                   = null,
  @SerializedName("type"              ) var type              : Type3?                  = Type3(),
  @SerializedName("timeValid"         ) var timeValid         : Boolean?               = null,
  @SerializedName("neutralSite"       ) var neutralSite       : Boolean?               = null,
  @SerializedName("boxscoreAvailable" ) var boxscoreAvailable : Boolean?               = null,
  @SerializedName("ticketsAvailable"  ) var ticketsAvailable  : Boolean?               = null,
  @SerializedName("venue"             ) var venue             : Venue3                 = Venue3(),
  @SerializedName("competitors"       ) var competitors       : List<Competitors3> = listOf(),
//  @SerializedName("notes"             ) var notes             : List<String>      = listOf(),
//  @SerializedName("broadcasts"        ) var broadcasts        : List<Broadcasts>  = listOf(),
  @SerializedName("tickets"           ) var tickets           : List<Tickets3>     = listOf(),
  @SerializedName("status"            ) var status            : Status3?                = Status3()

)