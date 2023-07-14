package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.StatsItemModel


data class Stats3(
  @SerializedName("name") var name: String? = null,
  @SerializedName("value") var value: Float? = null,
  )

fun Stats3.asStatsItemModel() : StatsItemModel {
  return StatsItemModel(
    name = name ?: "",
    value = value ?: 0f
  )
}

fun Stats3.toDomainStatsModelList(initial: List<Stats3>): List<StatsItemModel> {
  return initial.map { it.asStatsItemModel() }
}


