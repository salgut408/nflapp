package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_team_detail_roster.AthletesRosterModel


data class Athletes(
  @SerializedName("id")
  val id: String = "",
  @SerializedName("uid")
  val uid: String = "",
  @SerializedName("guid")
  val guid: String = "",
  @SerializedName("type")
  val type: String = "",
  @SerializedName("alternateIds")
  val alternateIds: AlternateIds? = AlternateIds(),
  @SerializedName("firstName")
  val firstName: String = "",
  @SerializedName("lastName")
  val lastName: String = "",
  @SerializedName("fullName")
  val fullName: String = "",
  @SerializedName("displayName")
  val displayName: String = "",
  @SerializedName("shortName")
  val shortName: String = "",
  @SerializedName("weight")
  val weight: Int = 0,
  @SerializedName("displayWeight")
  val displayWeight: String = "",
  @SerializedName("height")
  val height: Int = 0,
  @SerializedName("displayHeight")
  val displayHeight: String = "",
  @SerializedName("age")
  val age: Int? = null,
  @SerializedName("dateOfBirth")
  val dateOfBirth: String = "",
  @SerializedName("debutYear")
  val debutYear: Int? = null,
  @SerializedName("birthPlace")
  val birthPlace: BirthPlace? = BirthPlace(),
  @SerializedName("slug")
  val slug: String = "",
  @SerializedName("headshot")
  val headshot: Headshot = Headshot(),
  @SerializedName("jersey")
  val jersey: String = "",
  @SerializedName("position")
  val position: Position = Position(),
  @SerializedName("injuries")
  val injuries: List<Injury>? = listOf(),
  @SerializedName("linked")
  val linked: Boolean? = null,
  @SerializedName("experience")
  val experience: Experience? = Experience(),
  @SerializedName("active")
  val active: Boolean? = null,
  @SerializedName("draft")
  val draft: Draft = Draft(),
  @SerializedName("flag")
  val flag: Flag? = Flag(),
)

data class Flag(
  @SerializedName("href") val href: String? = "",
  )

data class Injury(
    @SerializedName("shortComment") val shortComment: String? = null,
    @SerializedName("longComment") val longComment: String? = null,
    @SerializedName("status") val injuryStatus: String? = null,
    @SerializedName("details") val detail: Details? = null,
    )

data class Details(
    @SerializedName("type") var type: String? = null,
    @SerializedName("location") var location: String? = null,
    @SerializedName("side") var side: String? = null,
    @SerializedName("detail") var detail: String? = null,
    @SerializedName("returnDate") var returnDate: String? = null,
)

fun Athletes.asGameDetailsAthlete(): GameDetailsAthleteDetailsModel {
    return GameDetailsAthleteDetailsModel(
        id = id,
        uid = uid,
        lastName = lastName,
        fullName = fullName,
        shortName = shortName,
        headshot = headshot.asDomain(),
        jersey = jersey,
        position = position.asDomain()

    )
}

fun Athletes.asDomain(): AthletesRosterModel {
    return AthletesRosterModel(
        id = id,
        uid = uid,
        guid = guid,
        type = type,
        firstName = firstName,
        lastName = lastName,
        fullName = fullName,
        displayName = displayName,
        shortName = shortName,
        displayWeight = displayWeight,
        displayHeight = displayHeight,
        age = age ?: 0,
        dateOfBirth = dateOfBirth,
        birthPlace = birthPlace,
        slug = slug,
        headshot = headshot,
        jersey = jersey,
        position = position,
        injuries = injuries,
        experience = experience,
        draft = draft,
        active = active,
        flag = flag


    )
}


























