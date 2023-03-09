package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models.LeagueModel


data class Leagues(

  @SerializedName("id") val id: String? = null,
  @SerializedName("uid") val uid: String? = null,
  @SerializedName("name") val name: String? = null,
  @SerializedName("abbreviation") val abbreviation: String? = null,
  @SerializedName("shortName") val shortName: String? = null,
  @SerializedName("slug") val slug: String? = null,
  @SerializedName("teams") val teams: List<Teams>? = null,

  )

fun Leagues.toDomain(): LeagueModel {
  return LeagueModel(
    id = id ?: "",
    uid = uid ?: "",
    name = name ?: "",
    abbreviation = abbreviation ?: "",
    shortName = shortName ?: "",
    slug = slug ?: "",
    teams = teams?.map { it.teamSingle.asDomainModel() } ?: listOf()
  )
}