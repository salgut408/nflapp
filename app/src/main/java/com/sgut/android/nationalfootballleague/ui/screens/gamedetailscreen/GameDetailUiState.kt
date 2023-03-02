package com.sgut.android.nationalfootballleague.ui.screens.gamedetailscreen

import com.sgut.android.nationalfootballleague.Athletes
import com.sgut.android.nationalfootballleague.GameDetailsTeams
import com.sgut.android.nationalfootballleague.NextEvent3
import com.sgut.android.nationalfootballleague.TeamScoreboard
import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.TeamDetailWithRosterModel

data class GameDetailsScreenUiState(
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentGameDetails: GameDetailModel? = null,

    )
