package com.sgut.android.nationalfootballleague.ui.screens.homelistscreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuthException
import com.sgut.android.nationalfootballleague.data.db.sport.SportDbObj
import com.sgut.android.nationalfootballleague.data.service.AccountService
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_article.ArticlesListModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.FullTeamsListsModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.SportModel
import com.sgut.android.nationalfootballleague.domain.domainmodels.new_models_teams_list.TeamModel
import com.sgut.android.nationalfootballleague.domain.repositories.TeamsListsRepository
import com.sgut.android.nationalfootballleague.domain.use_cases.GetArticlesUseCase
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASEBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.CHAMPIONS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.EPL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FIFA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.HOCKEY
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.LA_LIGA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.MLB
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.MLS
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NBA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASEBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_BASKETBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NCAA_FOOTBALL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NFL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.NHL
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.SOCCER
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.UEFA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.WBC
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.WNBA
import com.sgut.android.nationalfootballleague.utils.Constants.Companion.XFL
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val accountService: AccountService,
    private val fullTeamsListRepository: TeamsListsRepository,
    private val getArticles: GetArticlesUseCase,
) : ViewModel() {

    private val _listUiState = MutableStateFlow(ListUiState())
    val listUiState: StateFlow<ListUiState> = _listUiState.asStateFlow()

//     TODO STORE ALL TEAMS IN DB FIRST THEN READ FROM THERE BASED ON LEAGUE ?

    init {
//        to start
        loadAllNflTeams()
    }

//    TODO Save Sport mapping tables

    fun addSportToDb(sport: SportDbObj) {

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

    fun callForCompleteTeamAndLeagueInfo(sport: String, league: String) = viewModelScope.launch {
        fullTeamsListRepository.getFullSportLeagueAndTeamsList(sport, league)
    }


    fun loadAllNflTeams() = viewModelScope.launch {
        try {
            val fullTeamsList =
                fullTeamsListRepository.getFullSportLeagueAndTeamsList(FOOTBALL, NFL)
            val news = getArticles(FOOTBALL, NFL)
//            Default list Ui State set here
            addTeamsToDb(
                teams = fullTeamsList.sport.league?.teams ?: listOf(),
                sport = fullTeamsList.sport.name,
                league = fullTeamsList.sport.league?.name ?: "",
                leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
            )
            setListUiState(
                currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
                currentSport = fullTeamsList.sport.slug,
                currentLeague = fullTeamsList.sport.league?.abbreviation ?: "",
                fullTeamInfo = fullTeamsList,
                sportModel = fullTeamsList.sport,
                news = news

            )


        }
        catch (e: Exception) {
            Log.e("tag", e.message.toString())
        }
    }

    fun setLaLigaTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, LA_LIGA)
        val news = getArticles(SOCCER, LA_LIGA)
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
    }


    fun setCollegeBaseballTeams() = viewModelScope.launch {
        val fullTeamsList =
            fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASEBALL, NCAA_BASEBALL)
        val news = getArticles(BASEBALL, NCAA_BASEBALL)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news

        )
    }

    fun setEnglishTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, EPL)
        val news = getArticles(SOCCER, EPL)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setXflTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(FOOTBALL, XFL)
        val news = getArticles(FOOTBALL, XFL)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.abbreviation ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setEuroTeams() = viewModelScope.launch() {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, UEFA)
        val news = getArticles(SOCCER, UEFA)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setBaseballTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASEBALL, MLB)
        val news = getArticles(BASEBALL, MLB)

        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )

    }

    fun genericSetTeamsThruState(sport: String, league: String) {
//        TODO
    }

    fun setCollegeBasketballTeams() = viewModelScope.launch {
        val fullTeamsList =
            fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASKETBALL, NCAA_BASKETBALL)
        val news = getArticles(BASKETBALL, NCAA_BASKETBALL)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setBasketballTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASKETBALL, NBA)
        val news = getArticles(BASKETBALL, NBA)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setFootballTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(FOOTBALL, NFL)
        val news = getArticles(FOOTBALL, NFL)
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }


    fun setHockeyTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(HOCKEY, NHL)
        val news = getArticles(HOCKEY, NHL)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setWnbaTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASKETBALL, WNBA)
        val news = getArticles(BASKETBALL, WNBA)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setChampionsTeam() = viewModelScope.launch {
        val fullTeamsList =
            fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, CHAMPIONS)
        val news = getArticles(SOCCER, CHAMPIONS)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setMlsTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, MLS)
        val news = getArticles(SOCCER, MLS)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setCollegeTeams() = viewModelScope.launch {
        val fullTeamsList =
            fullTeamsListRepository.getFullSportLeagueAndTeamsList(FOOTBALL, NCAA_FOOTBALL)
        val news = getArticles(FOOTBALL, NCAA_FOOTBALL)
        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
    }

    fun setWorldCupTeams() = viewModelScope.launch {
        val fullTeamsList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(SOCCER, FIFA)
        val news = getArticles(SOCCER, FIFA)

        addTeamsToDb(
            teams = fullTeamsList.sport.league?.teams ?: listOf(),
            sport = fullTeamsList.sport.name,
            league = fullTeamsList.sport.league?.name ?: "",
            leagueAbrv = fullTeamsList.sport.league?.abbreviation ?: ""
        )
        setListUiState(
            currentTeams = fullTeamsList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamsList.sport.slug,
            currentLeague = fullTeamsList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamsList,
            sportModel = fullTeamsList.sport,
            news = news
        )
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

    private fun setAccount() = viewModelScope.launch {
        if (!accountService.hasUser) {
            createAnonymousAccount()
        }
    }

    private fun createAnonymousAccount() = viewModelScope.launch {
        try {
            accountService.createAnonymousAccount()
        }
        catch (ex: FirebaseAuthException) {
            throw ex
        }
    }

    fun setWbc() = viewModelScope.launch {
        val fullTeamList = fullTeamsListRepository.getFullSportLeagueAndTeamsList(BASEBALL, WBC)
        val news = getArticles(BASEBALL, WBC)

        setListUiState(
            currentTeams = fullTeamList.sport.league?.teams ?: listOf(),
            currentSport = fullTeamList.sport.slug,
            currentLeague = fullTeamList.sport.league?.slug ?: "",
            fullTeamInfo = fullTeamList,
            news = news,
            sportModel = fullTeamList.sport
        )

    }
}