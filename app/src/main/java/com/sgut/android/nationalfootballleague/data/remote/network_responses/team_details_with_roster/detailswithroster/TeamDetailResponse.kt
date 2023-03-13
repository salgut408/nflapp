package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailResponseModel


data class TeamDetailResponse2 (

  @SerializedName("team") var fullTeam : Team3? = Team3()

)

fun TeamDetailResponse2.asDomainModel(): FullTeamDetailResponseModel {
  return FullTeamDetailResponseModel(
    fullTeam = fullTeam?.asDomain()!!
  )
}