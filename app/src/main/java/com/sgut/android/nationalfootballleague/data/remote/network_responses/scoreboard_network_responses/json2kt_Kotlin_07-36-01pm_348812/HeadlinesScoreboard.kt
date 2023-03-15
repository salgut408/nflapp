package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardHeadlineModel


data class HeadlinesScoreboard(

  @SerializedName("description")
  val description: String? = null,
  @SerializedName("type")
  val type: String? = null,
  @SerializedName("shortLinkText")
  val shortLinkText: String? = null,

  )

fun HeadlinesScoreboard.asDomain(): ScoreboardHeadlineModel {
  return ScoreboardHeadlineModel(
    description = description ?: "",
    type = type ?: "",
    shortLinkText = shortLinkText ?: ""
  )
}