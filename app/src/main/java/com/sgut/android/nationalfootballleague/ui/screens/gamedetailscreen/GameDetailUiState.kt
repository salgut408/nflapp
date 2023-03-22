package com.sgut.android.nationalfootballleague.ui.screens.gamedetailscreen

import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsModel

data class GameDetailsScreenUiState(
    val currentSport: String = "",
    val currentLeague: String = "",
    val currentGameDetails: GameDetailModel? = null,
    val currentGameUiState: GameDetailsModel? = null

    )
