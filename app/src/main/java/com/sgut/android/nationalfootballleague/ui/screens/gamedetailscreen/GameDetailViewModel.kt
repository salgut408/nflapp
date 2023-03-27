package com.sgut.android.nationalfootballleague.ui.screens.gamedetailscreen

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsModel
import com.sgut.android.nationalfootballleague.domain.repositories.GameDetailsRepository
import com.sgut.android.nationalfootballleague.ui.screens.teamdetails.HexToJetpackColor2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameDetailViewModel @Inject constructor(
    private val gameDetailsRepository: GameDetailsRepository,
) : ViewModel() {

    private val _gameDetailUiState = MutableStateFlow(GameDetailsScreenUiState())
    var gameDetailUiState: StateFlow<GameDetailsScreenUiState> = _gameDetailUiState.asStateFlow()

    var _colorsTeamList: MutableList<Color> = mutableListOf()


    init {}


    fun loadGameDetails(
        sport: String,
        league: String,
        event: String,
    ) = viewModelScope.launch {
        try {

            val newGameDeetUiState = gameDetailsRepository.getGameDetails(sport, league, event)

            setGameDetailsUiState( sport, league, newGameDeetUiState)
            Log.i("NEWGAMEDEETUI", newGameDeetUiState.rosters.toString())

            newGameDeetUiState.boxscore?.teams?.forEach { i ->
                _colorsTeamList.add(HexToJetpackColor2.getColor(i.team?.color ?: "Color"))
            }
            _colorsTeamList.add(Color.Black)
        }
        catch (e: Exception) {
            Log.e("DEBUG DETAILS", e.message.toString())
        }
    }

    fun onSaveArticleClick(article: GameDetailModel) = viewModelScope.launch {
//        espnRepository.saveArticle(article)

    }

//    fun getHomeTeam:


   private fun setGameDetailsUiState(
        currentSport: String,
        currentLeague: String,
        curentGameUiState: GameDetailsModel,
    ) {
        _gameDetailUiState.update {
            it.copy(
                currentLeague = currentLeague,
                currentSport = currentSport,
                currentGameUiState = curentGameUiState
            )
        }
    }

}