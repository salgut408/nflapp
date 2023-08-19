package com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard

import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.DefaultLogo
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.LogosModel

interface DefaultLeagueInterface{
    val abbreviation: String
    val name: String
    val logos: List<DefaultLogo>
}

data class DefaultLeagueModel(
  override  val abbreviation: String ="",
    val id: String = "",
   override val logos: List<LogosModel> = listOf(),
  override  val name: String ="",
    val slug: String ="",
    val uid: String ="",
) : DefaultLeagueInterface