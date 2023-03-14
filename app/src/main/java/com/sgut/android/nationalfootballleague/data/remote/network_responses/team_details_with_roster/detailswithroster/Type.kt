package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.CompetitionTypeModel


data class Type3(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("name")
  val name: String? = null,
  @SerializedName("state")
  val state: String? = null,
  @SerializedName("completed")
  val completed: Boolean? = null,
  @SerializedName("description")
  val description: String? = null,
  @SerializedName("detail")
  val detail: String? = null,
  @SerializedName("shortDetail")
  val shortDetail: String? = null,

  )

fun Type3.asDomain(): CompetitionTypeModel {
  return  CompetitionTypeModel(
    id = id ?: "",
    state = state ?: "",
    completed = completed,
    description = description ?: "",
    detail =  detail ?: "",
    shortDetail = shortDetail ?: ""
  )
}