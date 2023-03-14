package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName


data class CompetitorsScoreboard(

  @SerializedName("id") val id: String? = null,
  @SerializedName("uid") val uid: String? = null,
  @SerializedName("type") val type: String? = null,
  @SerializedName("order") val order: Int? = null,
  @SerializedName("homeAway") val homeAway: String? = null,
  @SerializedName("winner") val winner: Boolean? = null,
  @SerializedName("form") val form: String? = null,
  @SerializedName("score") val score: String? = null,
  @SerializedName("records") val records: ArrayList<RecordsScoreboard> = arrayListOf(),
  @SerializedName("team") val team: TeamScoreboard? = TeamScoreboard(),
  @SerializedName("statistics") val statistics: ArrayList<StatisticsScoreboard> = arrayListOf(),

  )