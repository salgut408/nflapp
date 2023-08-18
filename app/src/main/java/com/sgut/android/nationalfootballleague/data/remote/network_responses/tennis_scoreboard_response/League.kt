package com.sgut.android.nationalfootballleague.data.remote.network_responses.tennis_scoreboard_response


import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.tennis_scoreboard_models.LeagueTennisModel
import com.sgut.android.nationalfootballleague.utils.formatTo
import com.sgut.android.nationalfootballleague.utils.toDate

data class League(
    @SerializedName("abbreviation")
    val abbreviation: String = "",
    @SerializedName("calendar")
    val calendar: List<String> = listOf(),
    @SerializedName("calendarEndDate")
    val calendarEndDate: String = "",
    @SerializedName("calendarIsWhitelist")
    val calendarIsWhitelist: Boolean = false,
    @SerializedName("calendarStartDate")
    val calendarStartDate: String = "",
    @SerializedName("calendarType")
    val calendarType: String = "",
    @SerializedName("id")
    val id: String = "",
    @SerializedName("logos")
    val logos: List<Logo> = listOf(),
    @SerializedName("midsizeName")
    val midsizeName: String = "",
    @SerializedName("name")
    val name: String = "",
    @SerializedName("season")
    val season: SeasonX = SeasonX(),
    @SerializedName("slug")
    val slug: String = "",
    @SerializedName("uid")
    val uid: String = ""
)

fun League.asDomain(): LeagueTennisModel{
    return LeagueTennisModel(
        abbreviation = abbreviation,
        calendar = calendar.map { it.toDate()?.formatTo("K:mm aa") ?: "" },
        calendarEndDate = calendarEndDate,
        calendarIsWhitelist = calendarIsWhitelist,
        calendarStartDate = calendarStartDate,
        calendarType = calendarType,
        id = id,
        logos = logos.map { it.asDomain() },
        midsizeName = midsizeName,
        name = name,
        season = season.asDomain(),
        slug = slug,
        uid = uid
    )
}