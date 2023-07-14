package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.EventLeagueModel


data class LeaguesScoreboard(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("uid")
    val uid: String? = null,
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("abbreviation")
    val abbreviation: String? = null,
    @SerializedName("midsizeName")
    val midsizeName: String? = null,
    @SerializedName("slug")
    val slug: String? = null,
    @SerializedName("logos")
    val logos: List<LogosScoreboard> = listOf(),
)



fun LeaguesScoreboard.asDomain(): EventLeagueModel {
    return EventLeagueModel(
        abbreviation = abbreviation ?: "",
        id = id ?: "",
        logos = logos.map { it.asDomain() },
        name = name ?: "",
        slug = slug ?: "",
        uid = uid ?: "",
//        calendar = calendar
    )
}