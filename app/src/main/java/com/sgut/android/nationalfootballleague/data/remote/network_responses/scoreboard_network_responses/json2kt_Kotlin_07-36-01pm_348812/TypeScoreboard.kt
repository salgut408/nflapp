package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.CompetitionTypeModel


data class TypeScoreboard(

  @SerializedName("id")
  val id: String = "",
  @SerializedName("name")
  val name: String = "",
  @SerializedName("state")
  val state: StatusState = StatusState.PRE,
  @SerializedName("completed")
  val completed: Boolean = false,
  @SerializedName("description")
  val description: String = "",
  @SerializedName("detail")
  val detail: String = "",
  @SerializedName("shortDetail")
  val shortDetail: String = "",
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
        state = state,
        completed = completed,
        description = description,
        detail = detail,
        shortDetail = shortDetail
    )
}