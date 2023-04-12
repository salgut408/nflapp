package com.sgut.android.nationalfootballleague.ui.screens.standings_screen

import com.sgut.android.nationalfootballleague.domain.domainmodels.standings_models.StandingsModel

data class StandingsUiState (
    val currentSport: String = "",
    val currentLeague: String = "",
    val standingsUiState: StandingsModel = StandingsModel()
)