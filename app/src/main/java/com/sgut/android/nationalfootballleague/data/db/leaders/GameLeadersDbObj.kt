package com.sgut.android.nationalfootballleague.data.db.leaders

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.AthleteLeaderModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsTeamInfoModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameLeadersModel

@Entity(tableName = "season_leaders")
data class GameLeadersDbObj(
    @PrimaryKey(autoGenerate = false)
    val gameId: String = "",
    val name: String = "",
    val displayName: String = "",
    val leadersAthlete: List<AthleteLeaderModel> = listOf(),
)

@Entity(tableName = "leaders_season")
data class GameDetailsLeadersDb(
    @PrimaryKey(autoGenerate = false)
    val gameId: String = "",
    val team: GameDetailsTeamInfoModel,
    val leaders: List<GameLeadersModel>
)
