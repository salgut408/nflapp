package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailWithRosterModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.FullTeamDetailsFranchiseModel


data class Team3 (

  @SerializedName("id"               ) var id               : String              = "",
  @SerializedName("uid"              ) var uid              : String             = "",
  @SerializedName("slug"             ) var slug             : String              = "",
  @SerializedName("location"         ) var location         : String              = "",
  @SerializedName("name"             ) var name             : String              = "",
  @SerializedName("nickname"         ) var nickname         : String              = "",
  @SerializedName("abbreviation"     ) var abbreviation     : String              = "",
  @SerializedName("displayName"      ) var displayName      : String              = "",
  @SerializedName("shortDisplayName" ) var shortDisplayName : String              = "",
  @SerializedName("color"            ) var color            : String              = "",
  @SerializedName("alternateColor"   ) var alternateColor   : String              = "FFFF",
  @SerializedName("isActive"         ) var isActive         : Boolean?             = null,
  @SerializedName("logos"            ) var logos            : List<Logos3>     = listOf(),
  @SerializedName("record"           ) var record           : Record3?              = Record3(),
  @SerializedName("athletes"         ) var athletes         : List<Athletes>  = listOf(),
  @SerializedName("groups"           ) var groups           : Groups3?              = Groups3(),
  @SerializedName("links"            ) var links            : List<Links3>     = listOf(),
  @SerializedName("franchise"        ) var franchise        : Franchise3?           = Franchise3(),
  @SerializedName("nextEvent"        ) var nextEvent        : List<NextEvent3> = listOf(),
  @SerializedName("standingSummary"  ) var standingSummary  : String              = ""

)

fun Team3.asDomain(): FullTeamDetailWithRosterModel {
  return FullTeamDetailWithRosterModel(
    id = id,
    uid = uid,
    slug = slug,
    location = location,
    name = name,
    abbreviation = abbreviation,
    displayName = displayName,
    shortDisplayName = shortDisplayName,
    color = color,
    alternateColor = alternateColor,
    logos = logos.map { it.asDomain() },
    record = record.asDomain(),
    franchise = franchise?.asDomain() ?: FullTeamDetailsFranchiseModel(),
    nickname = nickname,
    athletes = athletes.map { it.asDomain() },
    nextEvent = nextEvent.map { it.asDomain() },
    standingSummary = standingSummary
  )
}


