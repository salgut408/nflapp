package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class CompetitionsScoreboard (

  @SerializedName("id"            ) var id            : String?                  = null,
  @SerializedName("uid"           ) var uid           : String?                  = null,
  @SerializedName("date"          ) var date          : String?                  = null,
  @SerializedName("startDate"     ) var startDate     : String?                  = null,
  @SerializedName("attendance"    ) var attendance    : Int?                     = null,
  @SerializedName("timeValid"     ) var timeValid     : Boolean?                 = null,
  @SerializedName("recent"        ) var recent        : Boolean?                 = null,
  @SerializedName("status"        ) var status        : StatusScoreboard?                  = StatusScoreboard(),
  @SerializedName("venue"         ) var venue         : VenueScoreboard?                   = VenueScoreboard(),
  @SerializedName("format"        ) var format        : FormatScoreboard?                  = FormatScoreboard(),
//  @SerializedName("notes"         ) var notes         : ArrayList<String>        = arrayListOf(),
  @SerializedName("geoBroadcasts" ) var geoBroadcasts : ArrayList<GeoBroadcastsScoreboard> = arrayListOf(),
  @SerializedName("broadcasts"    ) var broadcasts    : ArrayList<BroadcastsScoreboard>    = arrayListOf(),
  @SerializedName("competitors"   ) var competitors   : ArrayList<CompetitorsScoreboard>   = arrayListOf(),
  @SerializedName("details"       ) var details       : ArrayList<DetailsScoreboard>       = arrayListOf(),
  @SerializedName("headlines"     ) var headlines     : ArrayList<HeadlinesScoreboard>     = arrayListOf(),


)



