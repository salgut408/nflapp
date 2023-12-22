package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.FullTeamsListsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.SportModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamsListsRepository
import com.sgut.android.nationalfootballleague.domain.use_cases.GetArticlesUseCase
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NFL
import com.sgut.android.nationalfootballleague.utils.printToLog
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val fullTeamsListRepository: TeamsListsRepository,
    private val getArticles: GetArticlesUseCase,
) : ViewModel() {

    private val _listUiState = MutableStateFlow(ListUiState())
    val listUiState: StateFlow<ListUiState> = _listUiState.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    init {
//        to start
        loadAllNflTeams()
    }

    fun addTeamsToDb(teams: List<TeamModel>, sport: String, league: String, leagueAbrv: String) =
        viewModelScope.launch {
            fullTeamsListRepository.storeTeamsInSportsDatabaseFullInfoTable(
                teams,
                sport,
                league,
                leagueAbrv
            )
        }


    //            Default list Ui State set here
    fun loadAllNflTeams() = viewModelScope.launch {
        try {
            val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(FOOTBALL, NFL)
            val news = getArticles(FOOTBALL, NFL)

            addTeamsToDb(
                teams = fullTeamsList .sport.league?.teams ?: listOf(),
                sport = fullTeamsList.sport.name,
                league = fullTeamsList.sport.league?.name ?: "",
                leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
            )
            setListUiState(
                currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
                currentSport = fullTeamsList.sport.name,
                currentLeague = fullTeamsList.sport.league?.abbreviation ?: "",
                fullTeamInfo = fullTeamsList,
                sportModel = fullTeamsList.sport,
                news = news
            )
        }
        catch (e: Exception) {
            Log.e("HOME_VM", e.stackTraceToString())
            _errorMessage.emit("An error happened loading all NFL Teams: ${e.message}")
        }
    }


    fun setDifferentTeams(sport: String, league: String) = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(sport, league)
        val news = getArticles(sport, league)

        news.printToLog("NEWS ARTICLE")
        try {
            addTeamsToDb(
                teams = fullTeamsList.sport.league?.teams ?: listOf(),
                sport = fullTeamsList.sport.name,
                league = fullTeamsList.sport.league?.name ?: "",
                leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
            )
            setListUiState(
                currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
                currentSport = fullTeamsList.sport.name,
                currentLeague = fullTeamsList.sport.league?.slug ?: "",
                fullTeamInfo = fullTeamsList,
                sportModel = fullTeamsList.sport,
                news = news
            )
        } catch (e: Exception){
            _errorMessage.emit("An error happened loading different  team: ${e.message}")
        }
    }

    private fun setListUiState(
        currentSport: String,
        currentLeague: String,
        currentTeams: List<TeamModel>,
        fullTeamInfo: FullTeamsListsModel,
        sportModel: SportModel,
        news: ArticlesListModel,
    ) {
        _listUiState.update {
            it.copy(
                currentSport = currentSport,
                currentLeague = currentLeague,
                currentTeams = currentTeams,
                fullTeamInfo = fullTeamInfo,
                sportModel = sportModel,
                currentNews = news
            )
        }
    }
}