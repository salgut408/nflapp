package com.sgut.android.nationalfootballleague.gamedetailscreen

import com.sgut.android.nationalfootballleague.data.domainmodels.GameDetailModel

sealed class SealedGameDetailUiState

object Success: SealedGameDetailUiState()
object Loading: SealedGameDetailUiState()
object Error: SealedGameDetailUiState()

data class GameDetailsLoaded(
    var currentSport: String = "",
    var currentLeague: String = "",
    val currentGameDetails: GameDetailModel? = null,
) : SealedGameDetailUiState()

