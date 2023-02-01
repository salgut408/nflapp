package com.sgut.android.nationalfootballleague.gamedetailscreen

import com.sgut.android.nationalfootballleague.Athletes
import com.sgut.android.nationalfootballleague.GameDetailsTeams
import com.sgut.android.nationalfootballleague.NextEvent3
import com.sgut.android.nationalfootballleague.TeamScoreboard
import com.sgut.android.nationalfootballleague.data.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.data.domainmodels.TeamDetailWithRosterModel

data class GameDetailsScreenUiState(
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentGameDetails: GameDetailModel? = null,

)
