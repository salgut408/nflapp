package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.DomainLogoModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsTeamInfoModel


data class GameDetailsTeam(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("uid")
    val uid: String? = null,
    @SerializedName("location")
    val location: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("nickname")
    val nickname: String? = null,
    @SerializedName("abbreviation")
    val abbreviation: String? = null,
    @SerializedName("displayName")
    val displayName: String? = null,
    @SerializedName("color")
    val color: String? = null,
    @SerializedName("alternateColor")
    val alternateColor: String? = null,
    @SerializedName("logos")
    val logos: List<GameDetailsLogos> = listOf(),
    @SerializedName("logo")
    val logo: String = "",
    @SerializedName("links")
    val links: List<GameDetailsLinks> = listOf(),
    @SerializedName("record")
    val record: List<GameDetailsRecord> = listOf(),


    )

fun GameDetailsTeam.asDomain(): GameDetailsTeamInfoModel {
    return GameDetailsTeamInfoModel (
        id = id ?: "",
        uid = uid ?: "",
        location = location ?: "",
        name = name ?: "",
        abbreviation = abbreviation ?: "",
        displayName = displayName ?: "",
        color = color ?: "",
        alternateColor = alternateColor ?: "",
        logos = logos.getOrNull(0)?.asDomainLogo() ?: DomainLogoModel(),
        logo = logo,
        record = record.map { it.asDomain() }
            )
}