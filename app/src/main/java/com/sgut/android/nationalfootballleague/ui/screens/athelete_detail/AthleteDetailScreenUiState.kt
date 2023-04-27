package com.sgut.android.nationalfootballleague.ui.screens.athelete_detail

import com.sgut.android.nationalfootballleague.domain.domainmodels.full_athlete.FullAthleteModel

data class AthleteDetailScreenUiState(
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentAthleteId: String = "",
    val currentFullInfo: FullAthleteModel = FullAthleteModel(),
//    val loading: Boolean = true
)