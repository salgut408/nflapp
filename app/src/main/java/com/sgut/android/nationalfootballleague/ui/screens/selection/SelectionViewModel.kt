package com.sgut.android.nationalfootballleague.ui.screens.selection

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.SportModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamsListsRepository
import com.sgut.android.nationalfootballleague.ui.screens.homelistscreen.ListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SelectionViewModel @Inject constructor(
    private val fullTeamsListRepository: TeamsListsRepository
): ViewModel() {
    private val _selectionUiState = MutableStateFlow(SportModel())
    val selectionUiState: StateFlow<SportModel> = _selectionUiState.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private suspend fun loadSport(sport: String, league: String) {

        val sport =  fullTeamsListRepository.getSport(sport, league)

        _selectionUiState.update {
            it.copy(
                id = sport.id,
                uid = sport.uid,
                name = sport.name,
                slug = sport.slug,
                league = sport.league
            )
        }
        Timber.d("SAL_GUT SPORT SELECTED: ${selectionUiState.value}")
    }

    fun setDifferentSport(sport: String, league: String) = viewModelScope.launch {
        loadSport(sport, league)
    }




}