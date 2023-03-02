package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsModel


data class NFLTeamsResponse (

  @SerializedName("sports" ) val sports : List<Sports>?


)


fun NFLTeamsResponse.toDomain(): FullTeamsModel {
  return FullTeamsModel(
    sports = sports?.map { it.toDomain() } ?: listOf()
  )
}
