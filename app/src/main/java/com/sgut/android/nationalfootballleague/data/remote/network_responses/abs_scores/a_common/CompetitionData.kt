package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.StatusCommX
import com.sgut.android.nationalfootballleague.data.remote.network_responses.baseball_scoreboard.Situation


abstract class CompetitionData {
    abstract val competitors: List<CompetitorData>
    abstract val id: String
    abstract val startDate: String
    abstract val status: StatusCommX?
    abstract val uid: String

}

data class DefaultCompetition(
    @SerializedName("competitors")
   override val competitors: List<DefaultCompetitor> = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("startDate")
    override val startDate: String = "",
    @SerializedName("status")
    override  val status: StatusCommX? = StatusCommX(),
    @SerializedName("uid")
    override val uid: String = "",
    ): CompetitionData()

data class BaseballCompetition(
    @SerializedName("competitors")
    override val competitors: List<BaseballCompetitor> = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("situation")
    val situation: Situation? = Situation(),
    @SerializedName("outsText")
    val outsText: String? = "",
    @SerializedName("startDate")
    override val startDate: String = "",
    @SerializedName("status")
    override  val status: StatusCommX? = StatusCommX(),
    @SerializedName("uid")
    override val uid: String = "",
    ): CompetitionData()


data class GolfCompetition(
    override val competitors: List<SingleCompetitor> = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("startDate")
    override val startDate: String = "",
    @SerializedName("status")
    override val status: StatusCommX? = StatusCommX(),
    @SerializedName("uid")
    override val uid: String = ""
): CompetitionData()

data class MmaCompetition(
    @SerializedName("competitors")
    override val competitors: List<SingleCompetitor> = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("startDate")
    override val startDate: String = "",
    @SerializedName("status")
    override val status: StatusCommX = StatusCommX(),
    @SerializedName("uid")
    override val uid: String = "",
): CompetitionData()

data class SoccerCompetition(
    @SerializedName("competitors")
    override val competitors: List<DefaultCompetitor> = listOf(),
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("startDate")
    override val startDate: String = "",
    @SerializedName("status")
    override val status: StatusCommX = StatusCommX(),
    @SerializedName("uid")
    override val uid: String = "",
): CompetitionData()

data class TennisCompetition(
    @SerializedName("competitors")
    override val competitors: List<SingleCompetitor> = listOf(),
    @SerializedName("id")
    override  val id: String = "",
    @SerializedName("major")
    val major: Boolean = false,
    @SerializedName("startDate")
    override val startDate: String = "",
    @SerializedName("status")
    override val status: StatusCommX? = StatusCommX(),
    @SerializedName("uid")
    override val uid: String = "",
): CompetitionData()


