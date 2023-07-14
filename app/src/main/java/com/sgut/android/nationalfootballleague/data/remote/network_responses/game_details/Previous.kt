package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.FootballPlayModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.PreviousModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.ScoringPlayModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.ScoringTypeModel


data class Previous(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("description")
    val description: String? = null,
    @SerializedName("team")
    val team: Team? = Team(),
    @SerializedName("start")
    val start: Start? = Start(),
    @SerializedName("end")
    val end: End? = End(),
    @SerializedName("timeElapsed")
    val timeElapsed: TimeElapsed? = TimeElapsed(),
    @SerializedName("yards")
    val yards: Int? = null,
    @SerializedName("isScore")
    val isScore: Boolean? = null,
    @SerializedName("offensivePlays")
    val offensivePlays: Int? = null,
    @SerializedName("result")
    val result: String? = null,
    @SerializedName("shortDisplayResult")
    val shortDisplayResult: String? = null,
    @SerializedName("displayResult")
    val displayResult: String? = null,
    @SerializedName("plays")
    val plays: List<Plays> = listOf(),

    )

fun Previous.asDomain(): PreviousModel {
    return PreviousModel(
        id = id ?: "",
        description = description ?: "",
        team = team?.asDomainModel(),
        timeElapsed = timeElapsed?.displayValue ?: "",
        yards = yards ?: 0,
        isScore = isScore ?: false,
        offensivePlays = offensivePlays ?: 0,
        result = result ?: "",
        displayResult = displayResult ?: "",
        shortDisplayResult = shortDisplayResult ?: "",
        plays = plays.map { it.asDomain() }
    )
}

data class TimeElapsed(

    @SerializedName("displayValue")
    val displayValue: String? = null,

    )


data class Start(

    @SerializedName("period")
    val period: Period? = Period(),
    @SerializedName("clock")
    val clock: Clock? = Clock(),
    @SerializedName("yardLine")
    val yardLine: Int? = null,
    @SerializedName("text")
    val text: String? = null,

    )

data class Period(

    @SerializedName("type") val type: String? = null,
    @SerializedName("number") val number: Int? = null,

    )

data class Clock(

    @SerializedName("displayValue") val displayValue: String? = null,

    )

data class End(

    @SerializedName("period") val period: Period? = Period(),
    @SerializedName("clock") val clock: Clock? = Clock(),
    @SerializedName("yardLine") val yardLine: Int? = null,
    @SerializedName("text") val text: String? = null,

    )

data class Plays(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("sequenceNumber")
    val sequenceNumber: String? = null,
    @SerializedName("type")
    val type: GameDetailsType? = GameDetailsType(),
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("awayScore")
    val awayScore: Int? = null,
    @SerializedName("homeScore")
    val homeScore: Int? = null,
    @SerializedName("period")
    val period: Period? = Period(),
    @SerializedName("clock")
    val clock: Clock? = Clock(),
    @SerializedName("scoringPlay")
    val scoringPlay: Boolean? = null,
    @SerializedName("priority")
    val priority: Boolean? = null,
    @SerializedName("modified")
    val modified: String? = null,
    @SerializedName("wallclock")
    val wallclock: String? = null,
    @SerializedName("start")
    val start: Start? = Start(),
    @SerializedName("end")
    val end: End? = End(),
    @SerializedName("statYardage")
    val statYardage: Int? = null,

    )
fun Plays.asDomain(): FootballPlayModel {
    return FootballPlayModel(
        type = type?.asDomain(),
        text = text ?: "",
        awayScore = awayScore ?: 0,
        homeScore = homeScore ?: 0,
        period = period?.number ?: 0,
        clock = clock?.displayValue ?: "",
        scoringPlay = scoringPlay ?: false,
        wallclock = wallclock ?: "",
        statYardage = statYardage ?: 0
    )
}

data class ScoringPlays(

    @SerializedName("id")
    val id: String? = null,
    @SerializedName("type")
    val type: GameDetailsType? = GameDetailsType(),
    @SerializedName("text")
    val text: String? = null,
    @SerializedName("awayScore")
    val awayScore: Int? = null,
    @SerializedName("homeScore")
    val homeScore: Int? = null,
    @SerializedName("period")
    val period: Period? = Period(),
    @SerializedName("clock")
    val clock: Clock? = Clock(),
    @SerializedName("team")
    val team: GameDetailsTeam? = GameDetailsTeam(),
    @SerializedName("scoringType")
    val scoringType: ScoringType? = ScoringType(),

    )

fun ScoringPlays.asDomain(): ScoringPlayModel {
    return ScoringPlayModel(
        id = id ?: "",
        type = type?.asDomain() ,
        awayScore = awayScore ?: 0,
        homeScore = homeScore ?: 0,
        period = period?.number ?: 0,
        clock = clock?.displayValue ?: "",
        team = team?.asDomain(),
        scoringType = scoringType?.asDomain()
    )
}

data class ScoringType(

    @SerializedName("name")
    val name: String? = null,
    @SerializedName("displayName")
    val displayName: String? = null,
    @SerializedName("abbreviation")
    val abbreviation: String? = null,

    )
fun ScoringType.asDomain(): ScoringTypeModel {
    return ScoringTypeModel(
        name = name ?: "",
        displayName = displayName ?: "",
        abbreviation = abbreviation ?: ""
    )
}