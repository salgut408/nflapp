package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.FullTeamsListsModel


data class NFLTeamsResponse (

  @SerializedName("sports" ) val sports : List<Sports>?


)


fun NFLTeamsResponse.toDomain(): FullTeamsListsModel {
  return FullTeamsListsModel(
    sport = sports?.get(0)?.toDomain()!!
  )
}
