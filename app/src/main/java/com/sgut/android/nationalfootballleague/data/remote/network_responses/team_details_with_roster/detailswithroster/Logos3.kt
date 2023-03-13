package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailsLogoModel


data class Logos3(

  @SerializedName("href") val href: String? = null,
  @SerializedName("width") val width: Int? = null,
  @SerializedName("height") val height: Int? = null,
  @SerializedName("alt") val alt: String? = null,
  @SerializedName("rel") val rel: List<String> = listOf(),
  @SerializedName("lastUpdated") val lastUpdated: String? = null,

  )

fun Logos3.asDomain() : FullTeamDetailsLogoModel {
  return FullTeamDetailsLogoModel(
    href = href ?: "",
    width = width ?: 0,
    height = height ?: 0
  )
}

fun List<Logos3>.toDomainModelList(initial: List<Logos3>): List<FullTeamDetailsLogoModel> {
  return initial.map { it.asDomain() }
}


