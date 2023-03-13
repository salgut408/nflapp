package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel


data class Team(

  @SerializedName("id") var id: String = "",
  @SerializedName("uid") val uid: String = "",
  @SerializedName("slug") val slug: String = "",
  @SerializedName("abbreviation") val abbreviation: String = "",
  @SerializedName("displayName") val displayName: String = "",
  @SerializedName("shortDisplayName") val shortDisplayName: String = "",
  @SerializedName("name") val name: String = "",
  @SerializedName("nickname") val nickname: String = "",
  @SerializedName("location") val location: String = "",
  @SerializedName("color") val color: String = "",
  @SerializedName("alternateColor") val alternateColor: String = "",
  @SerializedName("isActive") val isActive: Boolean? = null,
  @SerializedName("isAllStar") val isAllStar: Boolean? = null,
  @SerializedName("logos") val logos: List<Logos> = listOf(),
  @SerializedName("links") val links: List<Links> = listOf(),

  )

fun Team.asDomainModel(): TeamModel{
  return TeamModel(
    id = id,
    uid = uid,
    slug = slug,
    abbreviation = abbreviation,
    displayName = displayName,
    shortDisplayName = shortDisplayName,
    name = name,
    nickname = nickname,
    location = location,
    color = color,
    alternateColor = alternateColor,
    logos =  logos.getOrNull(0)?.href.toString() ?: ""
  )


}

fun Team.toDomainModelList(initial: List<Team>): List<TeamModel> {
  return initial.map { it.asDomainModel() }
}