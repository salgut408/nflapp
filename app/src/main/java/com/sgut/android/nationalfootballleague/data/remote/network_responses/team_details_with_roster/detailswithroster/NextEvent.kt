package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.NextEventModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.SeasonTypeModel


data class NextEvent3(

  @SerializedName("id") val id: String = "",
  @SerializedName("date") val date: String = "",
  @SerializedName("name") val name: String = "",
  @SerializedName("shortName") val shortName: String = "",
  @SerializedName("season") val season: Season3 = Season3(),
  @SerializedName("seasonType") val seasonType: SeasonType3? = SeasonType3(),
  @SerializedName("week") val week: Week3 = Week3(),
  @SerializedName("timeValid") val timeValid: Boolean = false,
  @SerializedName("competitions") val competitions: List<Competitions3> = listOf(),
  @SerializedName("links") val links: List<Links3> = listOf(),

  )

fun NextEvent3.asDomain(): NextEventModel {
  return NextEventModel(
    id = id,
    date = date,
    name = name,
    shortName = shortName,
    season = season.asDomain(),
    seasonType = seasonType?.asDomain() ?: SeasonTypeModel(),
    week = week?.asDomain(),
    competitions = competitions.map { it.asDomain() }
  )
}