package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.CompetitionTypeModel


data class TypeScoreboard(

  @SerializedName("id")
  val id: String? = null,
  @SerializedName("name")
  val name: String? = null,
  @SerializedName("state")
  val state: StatusState? = null,
  @SerializedName("completed")
  val completed: Boolean? = null,
  @SerializedName("description")
  val description: String? = null,
  @SerializedName("detail")
  val detail: String? = null,
  @SerializedName("shortDetail")
  val shortDetail: String? = null,
  )

enum class StatusState {
    @SerializedName("post")
    POST,
    @SerializedName("in")
    IN,
    @SerializedName("pre")
    PRE
}

fun TypeScoreboard.asDomain(): CompetitionTypeModel {
    return CompetitionTypeModel(
        id = id ?: "",
        state = state ?: StatusState.PRE,
        completed = completed,
        description = description ?: "",
        detail = detail ?: "",
        shortDetail = shortDetail ?: ""
    )
}