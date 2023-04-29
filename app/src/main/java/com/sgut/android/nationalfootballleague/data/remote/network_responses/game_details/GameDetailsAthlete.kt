package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.BatsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel4
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.ThrowModel


data class GameDetailsAthlete(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("uid")
    val uid: String? = null,
    @SerializedName("guid")
    val guid: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("fullName")
    val fullName: String? = null,
    @SerializedName("displayName")
    val displayName: String? = null,
    @SerializedName("shortName")
    val shortName: String? = null,
    @SerializedName("headshot")
    val headshot: GameDetailsHeadshot? = GameDetailsHeadshot(),
    @SerializedName("jersey")
    val jersey: String? = null,
    @SerializedName("position")
    val position: GameDetailsPosition? = GameDetailsPosition(),

    )

data class GameDetailsAthlete4(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("uid")
    val uid: String? = null,
    @SerializedName("guid")
    val guid: String? = null,
    @SerializedName("lastName")
    val lastName: String? = null,
    @SerializedName("fullName")
    val fullName: String? = null,
    @SerializedName("displayName")
    val displayName: String? = null,
    @SerializedName("shortName")
    val shortName: String? = null,
    @SerializedName("headshot")
    val headshot: String? = "",
    @SerializedName("jersey")
    val jersey: String? = null,
    @SerializedName("position")
    val position: GameDetailsPosition? = GameDetailsPosition(),
)

fun GameDetailsAthlete4.asDomain(): GameDetailsAthleteDetailsModel4 {
    return GameDetailsAthleteDetailsModel4(
        id = id ?: "",
        uid = uid ?: "",
        lastName = lastName ?: "",
        fullName = fullName ?: "",
        displayName = displayName ?: "",
        shortName = shortName ?: "",
        headshot = headshot ?: "",
        jersey = jersey ?: "",
        position = position?.asDomain(),
    )
}




fun GameDetailsAthlete.asDomain(): GameDetailsAthleteDetailsModel {
    return GameDetailsAthleteDetailsModel(
        id = id ?: "",
        uid = uid ?: "",
        lastName = lastName ?: "",
        fullName = fullName ?: "",
        displayName = displayName ?: "",
        shortName = shortName ?: "",
        headshot = headshot?.asDomain(),
        jersey = jersey ?: "",
        position = position?.asDomain(),
//        throws = throws.asDomain(),
//        bats = bats.asDomain()
    )
}

data class Bats(
    @SerializedName("type")
    val type: String = "",
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("displayValue")
    val displayValue: String = "",
)

fun Bats.asDomain(): BatsModel {
return BatsModel(
    type = type,
    abbreviation = abbreviation,
    displayValue = displayValue,
)
}



data class Throw(
  @SerializedName("type")
  val type: String = "",
  @SerializedName("abbreviation")
  val abbreviation: String = "",
  @SerializedName("displayValue")
  val displayValue: String = "",
  )

fun Throw.asDomain(): ThrowModel {
    return ThrowModel(
        type = type,
        abbreviation = abbreviation,
        displayValue = displayValue,
    )
}