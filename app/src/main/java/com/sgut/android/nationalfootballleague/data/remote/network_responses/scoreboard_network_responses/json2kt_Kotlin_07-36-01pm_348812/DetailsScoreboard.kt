package com.sgut.android.nationalfootballleague

import com.google.gson.annotations.SerializedName
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardDetailsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_scoreboard.ScoreboardTeamModel


data class DetailsScoreboard(

  @SerializedName("type")
  val type: TypeScoreboard? = TypeScoreboard(),
  @SerializedName("clock")
  val clock: ClockScoreboard? = ClockScoreboard(),
  @SerializedName("team")
  val team: TeamScoreboard? = TeamScoreboard(),
  @SerializedName("scoreValue")
  val scoreValue: Int? = null,
  @SerializedName("scoringPlay")
  val scoringPlay: Boolean? = null,
  @SerializedName("redCard")
  val redCard: Boolean? = null,
  @SerializedName("yellowCard")
  val yellowCard: Boolean? = null,
  @SerializedName("penaltyKick")
  val penaltyKick: Boolean? = null,
  @SerializedName("ownGoal")
  val ownGoal: Boolean? = null,
  @SerializedName("shootout")
  val shootout: Boolean? = null,
  @SerializedName("athletesInvolved")
  val athletesInvolved: List<AthletesInvolvedScoreboard> = listOf(),

  )

fun DetailsScoreboard.asDomain(): ScoreboardDetailsModel {
  return ScoreboardDetailsModel(
    type = type?.asDomain(),
    clock = clock?.asDomain(),
    team = team?.asDomain() ?: ScoreboardTeamModel(),
    scoreValue = scoreValue ?: 0,
    scoringPlay = scoringPlay ?: false,
    redCard = redCard,
    yellowCard = yellowCard,
    penaltyKick = penaltyKick,
    ownGoal = ownGoal,
    shootout = shootout,
    athletesInvolved = athletesInvolved.map{ it.asDomain() }
  )
}