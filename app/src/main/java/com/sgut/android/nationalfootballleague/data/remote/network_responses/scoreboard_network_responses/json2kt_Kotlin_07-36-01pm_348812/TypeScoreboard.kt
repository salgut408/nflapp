package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.CompetitionTypeModel


data class TypeScoreboard (

  @SerializedName("id"          ) var id          : String?  = null,
  @SerializedName("name"        ) var name        : String?  = null,
  @SerializedName("state"       ) var state       : String?  = null,
  @SerializedName("completed"   ) var completed   : Boolean? = null,
  @SerializedName("description" ) var description : String?  = null,
  @SerializedName("detail"      ) var detail      : String?  = null,
  @SerializedName("shortDetail" ) var shortDetail : String?  = null

)

fun TypeScoreboard.asDomain(): CompetitionTypeModel {
  return  CompetitionTypeModel(
    id = id ?: "",
    state = state ?: "",
    completed = completed,
    description = description ?: "",
    detail =  detail ?: "",
    shortDetail = shortDetail ?: ""
  )
}