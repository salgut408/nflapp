package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.RecordItemModel


data class Items3 (
  @SerializedName("type"    ) val type    : String?          = null,
  @SerializedName("summary" ) val summary : String?          = null,
  @SerializedName("stats"   ) val stats   : List<Stats3?> = listOf()
)

fun Items3.asRecordItemModel(): RecordItemModel {
  return RecordItemModel(
    type = type ?: "",
    summary = summary ?: "",
    stats = stats.map { it?.asStatsItemModel()!!}
  )
}