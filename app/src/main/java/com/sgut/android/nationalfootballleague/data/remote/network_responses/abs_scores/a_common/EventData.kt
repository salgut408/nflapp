package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.Circuit
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.Grouping

abstract class EventData {
    abstract val competitions: List<CompetitionData>?
    abstract val id: String
    abstract val name: String
    abstract val shortName: String
    abstract val uid: String
}

data class DefaultEvent(
    @SerializedName("competitions")
   override val competitions: List<DefaultCompetition>? = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("shortName")
    override val shortName: String = "",
    @SerializedName("uid")
    override val uid: String = ""
): EventData()

data class BaseballEvent(
    @SerializedName("competitions")
    override val competitions: List<BaseballCompetition>? = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("shortName")
    override val shortName: String = "",
    @SerializedName("uid")
    override val uid: String = ""
): EventData()

data class GolfEvent(
    @SerializedName("competitions")
    override val competitions: List<GolfCompetition>? = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("shortName")
    override val shortName: String = "",
    @SerializedName("uid")
    override val uid: String = ""
): EventData()

data class MmaEvent(
    @SerializedName("competitions")
    override val competitions: List<MmaCompetition>? = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("shortName")
    override val shortName: String = "",
    @SerializedName("uid")
    override val uid: String = ""
): EventData()

data class SoccerEvent(
    @SerializedName("competitions")
    override val competitions: List<SoccerCompetition>? = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("shortName")
    override val shortName: String = "",
    @SerializedName("uid")
    override val uid: String = ""
): EventData()

data class RacingEvent(
    @SerializedName("circuit")
    val circuit: Circuit = Circuit(),
    @SerializedName("competitions")
    override val competitions: List<DefaultCompetition>? = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("shortName")
    override val shortName: String = "",
    @SerializedName("uid")
    override val uid: String = ""
): EventData()

data class TennisEvent(
    @SerializedName("groupings")
    val groupings: List<Grouping> = listOf(),
    @SerializedName("competitions")
    override val competitions: List<CompetitionData>? = null,
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("name")
    override val name: String = "",
    @SerializedName("shortName")
    override val shortName: String = "",
    @SerializedName("uid")
    override val uid: String = ""
): EventData()



