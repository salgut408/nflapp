package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class EventsScoreboard (

  @SerializedName("id"           ) var id           : String?                 = null,
  @SerializedName("uid"          ) var uid          : String?                 = null,
  @SerializedName("date"         ) var date         : String?                 = null,
  @SerializedName("name"         ) var name         : String?                 = null,
  @SerializedName("shortName"    ) var shortName    : String?                 = null,
  @SerializedName("season"       ) var season       : SeasonScoreboard?                 = SeasonScoreboard(),
  @SerializedName("competitions" ) var competitions : List<CompetitionsScoreboard> = listOf(),
  @SerializedName("status"       ) var status       : StatusScoreboard                 = StatusScoreboard(),
  @SerializedName("links"        ) var links        : ArrayList<LinksScoreboard>        = arrayListOf()

)