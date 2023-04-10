package com.sgut.android.nationalfootballleague.ui.screens.gamedetailscreen

import android.util.Log
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.GameDetailModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsAthleteDetailsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_game_details.GameDetailsModel
import com.sgut.android.nationalfootballleague.domain.repositories.GameDetailsRepository
import com.sgut.android.nationalfootballleague.domain.use_cases.PlayersMapUseCase
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
    private val playersMap: PlayersMapUseCase,
) : ViewModel() {


//    TODO Move map from useCase to uiState

    private val _gameDetailUiState = MutableStateFlow(GameDetailsScreenUiState())
    var gameDetailUiState: StateFlow<GameDetailsScreenUiState> = _gameDetailUiState.asStateFlow()

    private val _colorsTeamList: MutableList<Color> = mutableListOf()

    var teamMap: Map<String, GameDetailsAthleteDetailsModel> = mapOf()


    init {
    }

    fun getPlayerFromId(id: String): GameDetailsAthleteDetailsModel {
        return teamMap[id] ?: GameDetailsAthleteDetailsModel()
    }



    fun loadGameDetails(
        sport: String,
        league: String,
        event: String,
    ) = viewModelScope.launch {
        try {
            val newGameDeetUiState = gameDetailsRepository.getGameDetails(sport, league, event)

            setGameDetailsUiState(sport, league, newGameDeetUiState)

            val teams = listOf(
                newGameDeetUiState.boxscore?.teams?.first()?.team?.abbreviation ?: "",
                newGameDeetUiState.boxscore?.teams?.last()?.team?.abbreviation ?: "",
            )

            teamMap = playersMap(sport, league, teams)


            Log.d("GAMEDEET_VIEWMODEL", newGameDeetUiState.baseballSituation .toString())

            newGameDeetUiState.boxscore?.teams?.forEach { i ->
                _colorsTeamList.add(HexToJetpackColor2.getColor(i.team?.color ?: "Color"))
            }
            _colorsTeamList.add(Color.Black)
        }
        catch (e: Exception) {
            Log.e("DEBUG_COLOR", e.message.toString())
        }
    }

    fun onSaveArticleClick(article: GameDetailModel) = viewModelScope.launch {
//        espnRepository.saveArticle(article)

    }

    private fun setGameDetailsUiState(
        currentSport: String,
        currentLeague: String,
        currentGameUiState: GameDetailsModel,
    ) {
        _gameDetailUiState.update {
            it.copy(
                currentLeague = currentLeague,
                currentSport = currentSport,
                currentGameUiState = currentGameUiState
            )
        }
    }


//      moved to use case for all player maps
//    fun loadPlayerMap(
//        sport: String,
//        league: String,
//        teamAbr: String
//    ) = viewModelScope.launch {
//        try {
//
//                teamMap += teamDetailsRepository.getSpecificTeamRosterInGameDetails(sport, league, teamAbr).associate { it.id to it }.toMutableMap()
//                Log.e("LOAD_ROSTER_MAP_SOLO", teamMap.toString())
//        } catch (e: Exception) {
//            Log.e("DEBUG DETAILS", e.message.toString())
//        }
//    }

}