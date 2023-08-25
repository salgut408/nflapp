package com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.AthleteGolf
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.a_common.comm.TeamComm
import com.sgut.android.nationalfootballleague.data.remote.network_responses.abs_scores.baseball.*

abstract class CompetitorData {
    abstract val homeAway: HomeAway
    abstract val id: String
    abstract val score: String
    abstract val team: TeamComm
    abstract val uid: String
    abstract val winner: Boolean

    enum class HomeAway {
        @SerializedName("home")
        HOME,
        @SerializedName("away")
        AWAY,
    }
}

data class DefaultCompetitor(
    @SerializedName("homeAway")
    override val homeAway: HomeAway = HomeAway.HOME,
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("score")
    override val score: String = "",
    @SerializedName("team")
    override val team: TeamComm = TeamComm(),
    @SerializedName("uid")
    override val uid: String = "",
    @SerializedName("winner")
    override val winner: Boolean = false

): CompetitorData()

data class SingleCompetitor(
    @SerializedName("homeAway")
    override val homeAway: HomeAway = HomeAway.HOME,
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("score")
    override val score: String = "",
    @SerializedName("team")
    override val team: TeamComm=TeamComm(),
    @SerializedName("uid")
    override val uid: String = "",
    @SerializedName("winner")
    override val winner: Boolean = false,
    @SerializedName("athlete")
val athlete: AthleteGolf = AthleteGolf(),
): CompetitorData()


data class BaseballCompetitor(
    @SerializedName("errors")
    val errors: Int = 0,
    @SerializedName("hits")
    val hits: Int = 0,
    @SerializedName("homeAway")
   override val homeAway: HomeAway = HomeAway.HOME,
    @SerializedName("id")
    override val id: String = "",
    @SerializedName("score")
    override val score: String = "",
    @SerializedName("team")
    override val team: TeamComm = TeamComm(),
    @SerializedName("uid")
    override val uid: String = "",
    @SerializedName("winner")
    override val winner: Boolean = false
): CompetitorData()