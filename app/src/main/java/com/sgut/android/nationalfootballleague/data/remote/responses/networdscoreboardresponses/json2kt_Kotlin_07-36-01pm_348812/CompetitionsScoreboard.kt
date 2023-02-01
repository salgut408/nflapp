package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class CompetitionsScoreboard (

  @SerializedName("id"            ) var id            : String?                  = null,
  @SerializedName("uid"           ) var uid           : String?                  = null,
  @SerializedName("date"          ) var date          : String?                  = null,
  @SerializedName("startDate"     ) var startDate     : String?                  = null,
  @SerializedName("attendance"    ) var attendance    : Int?                     = null,
  @SerializedName("timeValid"     ) var timeValid     : Boolean?                 = null,
  @SerializedName("status"        ) var status        : StatusScoreboard?                  = StatusScoreboard(),
  @SerializedName("venue"         ) var venue         : VenueScoreboard?                   = VenueScoreboard(),
  @SerializedName("format"        ) var format        : FormatScoreboard?                  = FormatScoreboard(),
  @SerializedName("geoBroadcasts" ) var geoBroadcasts : List<GeoBroadcastsScoreboard> = listOf(),
  @SerializedName("broadcasts"    ) var broadcasts    : List<BroadcastsScoreboard>    = listOf(),
  @SerializedName("competitors"   ) var competitors   : List<CompetitorsScoreboard>   = listOf(),
  @SerializedName("details"       ) var details       : List<DetailsScoreboard>       = listOf(),
  @SerializedName("headlines"     ) var headlines     : List<HeadlinesScoreboard>     = listOf(),


  )



