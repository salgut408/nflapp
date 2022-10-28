package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class Competitions (

  @SerializedName("id"                ) var id                : String?                = null,
  @SerializedName("date"              ) var date              : String?                = null,
  @SerializedName("attendance"        ) var attendance        : Int?                   = null,
  @SerializedName("type"              ) var type              : Type?                  = Type(),
  @SerializedName("timeValid"         ) var timeValid         : Boolean?               = null,
  @SerializedName("neutralSite"       ) var neutralSite       : Boolean?               = null,
  @SerializedName("boxscoreAvailable" ) var boxscoreAvailable : Boolean?               = null,
  @SerializedName("ticketsAvailable"  ) var ticketsAvailable  : Boolean?               = null,
  @SerializedName("venue"             ) var venue             : Venue?                 = Venue(),
  @SerializedName("competitors"       ) var competitors       : List<Competitors> = listOf(),
  @SerializedName("notes"             ) var notes             : List<String>      = listOf(),
  @SerializedName("broadcasts"        ) var broadcasts        : List<String>      = listOf(),
  @SerializedName("tickets"           ) var tickets           : List<Tickets>     = listOf(),
  @SerializedName("status"            ) var status            : Status?                = Status()

)