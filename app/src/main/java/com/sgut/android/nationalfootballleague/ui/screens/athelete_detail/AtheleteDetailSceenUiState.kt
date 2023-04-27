package com.sgut.android.nationalfootballleague.ui.screens.athelete_detail

import com.sgut.android.nationalfootballleague.domain.domainmodels.full_athlete.FullAthleteModel

data class AtheleteDetailSceenUiState(
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentAtheleteId: String = "",
    val currentFullInfo: FullAthleteModel = FullAthleteModel(),
//    val loading: Boolean = true
)