package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.RecordModel


data class Record3(
  @SerializedName("items")
  val recordItems: List<Items3>? = listOf(),
  )

fun Record3?.asDomain(): RecordModel {
  return RecordModel(
    recordItems = this?.recordItems?.map { it.asRecordItemModel() } ?: listOf()
  )
}