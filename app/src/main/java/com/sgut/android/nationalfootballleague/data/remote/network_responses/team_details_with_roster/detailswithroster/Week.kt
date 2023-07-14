package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.WeekModel


data class Week3(

  @SerializedName("number")
  val number: Int? = null,
  @SerializedName("text")
  val text: String? = null,
  )

fun Week3.asDomain(): WeekModel {
  return WeekModel(
    number = number ?: 0,
    text = text ?: ""
  )
}